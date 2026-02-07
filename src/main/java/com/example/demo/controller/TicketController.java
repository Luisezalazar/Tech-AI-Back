package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ticket;
import com.example.demo.service.ITicketService;


@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets() {
        List<Ticket> listTicket = ticketService.getAllTickets();
        return listTicket;
    }

    @GetMapping("/getTicketById/{id}")
    public Ticket getTicketById(Integer id) {
        Ticket tic = ticketService.getTicketById(id);
        return tic;
    }

    @PostMapping("/saveTicket")
    public void saveTicket(Ticket ticket) {
        ticketService.saveTicket(ticket);
    }

    @DeleteMapping("/deleteTicket/{id}")
    public void deleteTicket(Integer id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping("/editTicket/{originalId}")
    public Ticket editTicket(@PathVariable Integer originalId,
            @RequestParam(required = false, name = "address") String newAddress,
            @RequestParam(required = false, name = "team") String newTeam,
            @RequestParam(required = false, name = "apartment") String newApartment,
            @RequestParam(required = false, name = "technician") String newTechnician,
            @RequestParam(required = false, name = "date") LocalDate newDate,
            @RequestParam(required = false, name = "state") String newState,
            @RequestParam(required = false, name = "description") String newDescription) {
        ticketService.editTicket(originalId, newAddress, newTeam, newApartment, newTechnician, newDate, newState,
                newDescription);
        Ticket tic = ticketService.getTicketById(originalId);
        return tic;

    }
}
