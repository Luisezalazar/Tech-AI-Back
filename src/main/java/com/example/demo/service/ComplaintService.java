package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Complaint;
import com.example.demo.repository.IComplaintRepository;

@Service
public class ComplaintService implements IComplaintService {

    @Autowired
    IComplaintRepository complaintRepo;

    @Override
    public List<Complaint> getAllComplaints() {
        List<Complaint> listComplaint = complaintRepo.findAll();
        return listComplaint;
    }

    @Override
    public Complaint getComplaintById(Integer id) {
        return complaintRepo.findById(id).orElse(null);
    }

    @Override
    public void saveComplaint(Complaint complaint) {
        complaintRepo.save(complaint);
    }

    @Override
    public void deleteComplaint(Integer id) {
        complaintRepo.deleteById(id);
    }

    @Override
    public void editComplaint(Integer originalId, String newState, int newComplaintNumber, String newEquipment, String newReferences, String newAddress, String newCategory, String newDescription, String newContact, String newContactNumber, String newObservations) {
        Complaint comp = this.getComplaintById(originalId);
        comp.setState(newState);
        comp.setComplaintNumber(newComplaintNumber);
        comp.setEquipment(newEquipment);
        comp.setComplaintReferences(newReferences);
        comp.setAddress(newAddress);
        comp.setCategory(newCategory);
        comp.setDescription(newDescription);
        comp.setContact(newContact);
        comp.setContactNumber(newContactNumber);
        comp.setObservations(newObservations);
        this.saveComplaint(comp);
    }

    @Override
    public void patchState(Integer id, String newState) {
        Complaint comp = complaintRepo.findById(id).orElse(null);
        comp.setState(newState);
        this.saveComplaint(comp);
    }

    @Override
    public void patchObservations(Integer id, String newObservations) {
        Complaint comp = complaintRepo.findById(id).orElse(null);
        comp.setObservations(newObservations);
        this.saveComplaint(comp);
    }

}
