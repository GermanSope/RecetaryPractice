package com.miRecetario.ProyectoRecetario.controllers;

import ch.qos.logback.core.net.server.Client;
import com.miRecetario.ProyectoRecetario.dto.PatientDTO;
import com.miRecetario.ProyectoRecetario.models.Patient;
import com.miRecetario.ProyectoRecetario.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/patient/{id}")
    public PatientDTO getPatientById(@PathVariable Long id){
        return patientRepository.findById(id).map(PatientDTO::new).orElse(null);
    }

    @PostMapping("/patients")
    public ResponseEntity<Object> createPatient (@RequestBody PatientDTO patientDTO){

        if (patientDTO.getFirstname().isEmpty() || patientDTO.getLastname().isEmpty() || patientDTO.getDni().isEmpty() || patientDTO.getUser().isEmpty()
                || patientDTO.getPassword().isEmpty() || patientDTO.getObraSocial().isEmpty() || patientDTO.getoSNum().isEmpty()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Optional<Patient> patientFound = patientRepository.findByUser(patientDTO.getUser());

        if (!patientFound.isEmpty()){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.FORBIDDEN);
        }

        Patient newPatient = new Patient(patientDTO.getFirstname(), patientDTO.getLastname(), patientDTO.getDni(), patientDTO.getUser(), patientDTO.getPassword(),
                patientDTO.getObraSocial(), patientDTO.getoSNum(), patientDTO.getCellphone());
        patientRepository.save(newPatient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
