package com.miRecetario.ProyectoRecetario.models;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Patient extends Person {

    private String user;
    private String password;
    private String obraSocial;
    private String oSNum;
    private String cellphone;

   @OneToMany(mappedBy="patient", fetch= FetchType.EAGER)
   private Set<Recipe> recipes = new HashSet<>();

   @ManyToMany(mappedBy = "patients")
   private List<Professional> professionals;

    public Patient() {
    }

    public Patient(String user, String password, String obraSocial, String oSNum, String cellphone) {
        this.user = user;
        this.password = password;
        this.obraSocial = obraSocial;
        this.oSNum = oSNum;
        this.cellphone = cellphone;
    }

    public Patient(String firstname, String lastname, String dni, String user, String password, String obraSocial, String oSNum) {
        super(firstname, lastname, dni);
        this.user = user;
        this.password = password;
        this.obraSocial = obraSocial;
        this.oSNum = oSNum;
    }

    public Patient(String firstname, String lastname, String dni, String user, String password, String obraSocial, String oSNum, String cellphone) {
        super(firstname, lastname, dni);
        this.user = user;
        this.password = password;
        this.obraSocial = obraSocial;
        this.oSNum = oSNum;
        this.cellphone = cellphone;
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
    }
}
