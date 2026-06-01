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

import com.example.demo.model.Complaint;
import com.example.demo.service.IComplaintService;

@RestController
@RequestMapping("/complaint")

public class ComplaintController {

    @Autowired
    private IComplaintService complaintService;

    @GetMapping("/getAllComplaints")
    public List<Complaint> getAllComplaints() {
        List<Complaint> listComplaint = complaintService.getAllComplaints();
        return listComplaint;
    }

    @GetMapping("/getComplaintById/{id}")
    public Complaint getComplaintById(@PathVariable Integer id) {
        Complaint comp = complaintService.getComplaintById(id);
        return comp;
    }

    @PostMapping("/saveComplaint")
    public void saveComplaint(@RequestBody Complaint complaint) {
        System.out.println(complaint);

        complaintService.saveComplaint(complaint);
    }

    @DeleteMapping("/deleteComplaint/{id}")
    public void deleteComplaint(@PathVariable Integer id) {
        complaintService.deleteComplaint(id);
    }

    @PatchMapping("/patchState/{id}")
    public Complaint patchState(@PathVariable Integer id, @RequestParam(required = false, name = "state") String newState,
            @RequestParam(required = false, name = "personId") Integer personId) {
        complaintService.patchState(id, newState,personId);
        Complaint comp = complaintService.getComplaintById(id);
        return comp;
    }

    @PatchMapping("/patchObservations/{id}")
    public Complaint patchObservations(@PathVariable Integer id, @RequestParam(required = false, name = "observations") String newObservations) {
        complaintService.patchObservations(id, newObservations);
        Complaint comp = complaintService.getComplaintById(id);
        return comp;
    }

    @PutMapping("/editComplaint/{originalId}")
    public Complaint editComplaint(@PathVariable Integer originalId, @RequestParam(required = false, name = "state") String newState,
            @RequestParam(required = false, name = "complaintNumber") int newComplaintNumber,
            @RequestParam(required = false, name = "equipment") String newEquipment,
            @RequestParam(required = false, name = "complaintReferences") String newReferences,
            @RequestParam(required = false, name = "address") String newAddress,
            @RequestParam(required = false, name = "category") String newCategory,
            @RequestParam(required = false, name = "description") String newDescription,
            @RequestParam(required = false, name = "contact") String newContact,
            @RequestParam(required = false, name = "contactNumber") String newContactNumber,
            @RequestParam(required = false, name = "observations") String newObservations) {
        complaintService.editComplaint(originalId, newState, newComplaintNumber, newEquipment, newReferences, newAddress, newCategory, newDescription, newContact, newContactNumber, newObservations);
        Complaint comp = complaintService.getComplaintById(originalId);
        return comp;
    }
}
