package com.miRecetario.ProyectoRecetario.dto;

import com.miRecetario.ProyectoRecetario.models.Patient;
import com.miRecetario.ProyectoRecetario.models.Professional;
import com.miRecetario.ProyectoRecetario.models.Recipe;

import java.time.LocalDateTime;
import java.util.Set;

public class RecipeDTO {

    private LocalDateTime date;
    private boolean state;



    public RecipeDTO(Recipe recipe) {
        this.date = recipe.getDate();
        this.state = recipe.isState();
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

}
