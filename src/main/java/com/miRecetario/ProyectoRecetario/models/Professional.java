package com.miRecetario.ProyectoRecetario.models;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Professional extends Person{


    private String especiality;
    private String user;
    private String password;

    @OneToMany(mappedBy="professional", fetch= FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    public Professional() {
    }

    public Professional(String especiality, String user, String password) {
        this.especiality = especiality;
        this.user = user;
        this.password = password;
    }

    public Professional(String user, String password, String firstname, String lastname, String dni) {
        super(firstname, lastname, dni);
        this.user = user;
        this.password = password;
    }

    public Professional(String firstname, String lastname, String dni, String especiality, String user, String password) {
        super(firstname, lastname, dni);
        this.especiality = especiality;
        this.user = user;
        this.password = password;
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
