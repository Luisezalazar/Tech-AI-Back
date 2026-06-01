package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return ticketService.getAllTickets();
    }

    @GetMapping("/getTicketById/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/saveTicket")
    public void saveTicket(@RequestBody Ticket ticket) {
        ticketService.saveTicket(ticket);
    }

    @DeleteMapping("/deleteTicket/{id}")
    public void deleteTicket(@PathVariable("id") Integer id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping("/editTicket/{originalId}")
    public Ticket editTicket(
            @PathVariable("originalId") Integer originalId,
            @RequestBody Ticket ticket) {

        return ticketService.editTicket(originalId, ticket);
    }

    @PatchMapping("/patchState/{id}")
    public Ticket patchState(
            @PathVariable("id") Integer id,
            @RequestParam("state") String state,
            @RequestParam(required = false, name = "personId") Integer personId) {

        return ticketService.patchState(id, state, personId);
    }
}