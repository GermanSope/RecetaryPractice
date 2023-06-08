package com.miRecetario.ProyectoRecetario.repositories;

import com.miRecetario.ProyectoRecetario.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}
