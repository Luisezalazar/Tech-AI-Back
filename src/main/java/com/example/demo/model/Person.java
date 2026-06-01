package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String dni;

    private String area;
    private String phone;
    private LocalDate birthDate;
    private LocalDate entryDate;

    // 1:1
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // N:N
    @ManyToMany
    @JoinTable(
            name = "person_ticket", 
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    @ToString.Exclude
    private List<Ticket> tickets;

    // 1:N
    @ManyToMany(mappedBy = "persons")
    @JsonIgnore
    @ToString.Exclude
    private List<Complaint> complaints;
}
