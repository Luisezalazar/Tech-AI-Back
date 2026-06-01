package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String team;

    @Column(nullable = false)
    private String apartment;

    @Column(nullable = false)
    private String technician;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String state;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    //N:M
    @ManyToMany(mappedBy = "tickets")
    @JsonIgnoreProperties("tickets")
    @ToString.Exclude
    private List<Person> persons;
}
