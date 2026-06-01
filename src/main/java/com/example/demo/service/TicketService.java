package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.model.Ticket;
import com.example.demo.repository.IPersonRepository;
import com.example.demo.repository.ITicketRepository;

@Service
public class TicketService implements ITicketService {

    @Autowired
    ITicketRepository ticketRepo;

    @Autowired
    IPersonRepository personRepo;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketRepo.findById(id).orElse(null);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepo.save(ticket);
    }

    @Override
    public void deleteTicket(Integer id) {
        ticketRepo.deleteById(id);
    }

    @Override
    public Ticket editTicket(Integer originalId, Ticket ticket) {
        Ticket tic = this.getTicketById(originalId);

        if (tic == null) {
            throw new RuntimeException("Ticket not found");
        }

        tic.setAddress(ticket.getAddress());
        tic.setTeam(ticket.getTeam());
        tic.setApartment(ticket.getApartment());
        tic.setTechnician(ticket.getTechnician());
        tic.setDate(ticket.getDate());
        tic.setState(ticket.getState());
        tic.setDescription(ticket.getDescription());

        return ticketRepo.save(tic);
    }

    @Override
    public Ticket patchState(Integer id, String state, Integer personId) {
        Ticket tic = this.getTicketById(id);

        if (tic == null) {
            throw new RuntimeException("Ticket not found");
        }

        tic.setState(state);

        if (("Finalizado".equalsIgnoreCase(state) || "Fuera de servicio".equalsIgnoreCase(state)) && personId != null) {
            Person person = personRepo.findById(personId).orElse(null);
            
            if (person != null) {
                if (!tic.getPersons().contains(person)) {
                    tic.getPersons().add(person);
                }
                
                if (!person.getTickets().contains(tic)) {
                    person.getTickets().add(tic);
                }
            }
        }

        return ticketRepo.save(tic);
    }
}