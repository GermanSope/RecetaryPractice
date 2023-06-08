package com.miRecetario.ProyectoRecetario.repositories;

import com.miRecetario.ProyectoRecetario.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
}
