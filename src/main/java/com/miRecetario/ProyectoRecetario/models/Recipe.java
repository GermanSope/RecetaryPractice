package com.miRecetario.ProyectoRecetario.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private LocalDateTime date;
    private boolean state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Recipe() {
    }

    public Recipe(LocalDateTime date, boolean state) {
        this.date = date;
        this.state = state;
    }

    public Recipe(LocalDateTime date, boolean state, Professional professional) {
        this.date = date;
        this.state = state;
        this.professional = professional;
    }

    public Recipe(LocalDateTime date, boolean state, Professional professional, Patient patient) {
        this.date = date;
        this.state = state;
        this.professional = professional;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
