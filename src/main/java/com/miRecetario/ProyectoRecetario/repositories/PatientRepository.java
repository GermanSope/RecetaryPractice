package com.miRecetario.ProyectoRecetario.repositories;

import com.miRecetario.ProyectoRecetario.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUser(String user);
}
