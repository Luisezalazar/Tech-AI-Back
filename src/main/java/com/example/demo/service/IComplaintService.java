package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Complaint;



public interface IComplaintService {

    public List<Complaint> getAllComplaints();

    public Complaint getComplaintById(Integer id);

    public void saveComplaint(Complaint complaint);

    public void deleteComplaint(Integer id);

    public void patchState(Integer id, String newState);

    public void patchObservations(Integer id, String newObservations);
    
    public void editComplaint(Integer originalId, String newState, int newComplaintNumber, String newEquipment, String newReferences, String newAddress, String newCategory, String newDescription, String newContact, String newContactNumber, String newObservations);
    
}
