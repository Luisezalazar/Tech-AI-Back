package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Ticket;


public interface ITicketService {

    public List<Ticket> getAllTickets();

    public Ticket getTicketById(Integer id);

    public void saveTicket(Ticket ticket);

    public void deleteTicket(Integer id);
    
    public void editTicket(Integer originalId, String newAddress, String newTeam, String newApartment, String newTechnician, LocalDate newDate, String newState, String newDescription);
}
