package com.miRecetario.ProyectoRecetario.repositories;

import com.miRecetario.ProyectoRecetario.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
