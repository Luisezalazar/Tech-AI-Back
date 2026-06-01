package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String state;

    @Column(unique = true)
    private Integer complaintNumber;

    @Column(nullable = false)
    private String equipment;

    private String complaintReferences;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDate date;

    private LocalTime time;

    @Column(nullable = false)
    private String category;
    private String description;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String contactNumber;

    private String observations;

    @ManyToMany
    @JoinTable(
            name = "complaint_person",
            joinColumns = @JoinColumn(name = "complaint_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @ToString.Exclude
    private List<Person> persons = new java.util.ArrayList<>();

}
