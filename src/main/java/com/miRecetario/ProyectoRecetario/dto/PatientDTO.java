package com.miRecetario.ProyectoRecetario.dto;

import com.miRecetario.ProyectoRecetario.models.Patient;

import java.util.Set;
import java.util.stream.Collectors;

public class PatientDTO {

    private String firstname;
    private String lastname;
    private String dni;
    private String user;
    private String password;
    private String obraSocial;
    private String oSNum;
    private String cellphone;
    private Set<RecipeDTO> repices;


    public PatientDTO(Patient patient) {
        this.firstname = patient.getFirstname();
        this.lastname= patient.getLastname();
        this.dni= patient.getDni();
        this.user = patient.getUser();
        this.password = patient.getPassword();
        this.obraSocial = patient.getObraSocial();
        this.oSNum = patient.getoSNum();
        this.cellphone = patient.getCellphone();
        this.repices = patient.getRecipes().stream().map(RecipeDTO::new).collect(Collectors.toSet());
    }

    public PatientDTO(String firstname, String lastname, String dni, String user, String password, String obraSocial, String oSNum) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.user = user;
        this.password = password;
        this.obraSocial = obraSocial;
        this.oSNum = oSNum;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getoSNum() {
        return oSNum;
    }

    public void setoSNum(String oSNum) {
        this.oSNum = oSNum;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Set<RecipeDTO> getRepices() {
        return repices;
    }

    public void setRepices(Set<RecipeDTO> repices) {
        this.repices = repices;
    }
}
