package com.miRecetario.ProyectoRecetario.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String firstname;
    private String lastname;
    private String dni;

    public Person() {
    }

    public Person(String firstname, String lastname, String dni) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
