package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ticket;

public interface ITicketService {

    public List<Ticket> getAllTickets();

    public Ticket getTicketById(Integer id);

    public void saveTicket(Ticket ticket);

    public void deleteTicket(Integer id);

    public Ticket editTicket(Integer originalId, Ticket ticket);

    public Ticket patchState(Integer id, String state,Integer personId);
}