package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.ITicketRepository;


@Service
public class TicketService implements ITicketService {

    @Autowired
    ITicketRepository ticketRepo;

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> listTicket = ticketRepo.findAll();
        return listTicket;
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
    public void editTicket(Integer originalId, String newAddress, String newTeam, String newApartment, String newTechnician, LocalDate newDate, String newState, String newDescription) {
        Ticket tic = this.getTicketById(originalId);
        tic.setAddress(newAddress);
        tic.setTeam(newTeam);
        tic.setApartment(newApartment);
        tic.setTechnician(newTechnician);
        tic.setDate(newDate);
        tic.setState(newState);
        tic.setDescription(newDescription);
        this.saveTicket(tic);
    }
    
}
