package com.miRecetario.ProyectoRecetario.dto;

import com.miRecetario.ProyectoRecetario.models.Professional;
import com.miRecetario.ProyectoRecetario.models.Recipe;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfessionalDTO {

    private String firstname;
    private String lastname;
    private String dni;
    private String especiality;
    private String user;
    private String password;
    private Set<RecipeDTO> repices;

    public ProfessionalDTO(Professional professional) {
        this.firstname = professional.getFirstname();
        this.lastname = professional.getLastname();
        this.dni = professional.getDni();
        this.especiality = professional.getEspeciality();
        this.user = professional.getUser();
        this.password = professional.getPassword();
        this.repices = professional.getRecipes().stream().map(RecipeDTO::new).collect(Collectors.toSet());
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

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
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

    public Set<RecipeDTO> getRepices() {
        return repices;
    }

    public void setRepices(Set<RecipeDTO> repices) {
        this.repices = repices;
    }
}
