package com.miRecetario.ProyectoRecetario.controllers;

import com.miRecetario.ProyectoRecetario.dto.PatientDTO;
import com.miRecetario.ProyectoRecetario.models.Patient;
import com.miRecetario.ProyectoRecetario.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<PatientDTO> getPatients(){
        return patientRepository.findAll().stream().map(PatientDTO::new).collect(toList());
    }

    //current hace referencia al cliente q esta logueado en el momento
    //Autentication trae el cliente logueado(usuario o contraseña).
    @GetMapping("/patient/current")
    public PatientDTO getPatient(Authentication authentication) {
        Patient patient = patientRepository.findByUser(authentication.getName()).get();
        return new PatientDTO (patient);
    }
}
