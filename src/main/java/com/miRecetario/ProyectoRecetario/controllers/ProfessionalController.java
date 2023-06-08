package com.miRecetario.ProyectoRecetario.controllers;

import com.miRecetario.ProyectoRecetario.dto.ProfessionalDTO;
import com.miRecetario.ProyectoRecetario.models.Professional;
import com.miRecetario.ProyectoRecetario.repositories.PersonRepository;
import com.miRecetario.ProyectoRecetario.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ProfessionalController {

    @Autowired
    ProfessionalRepository professionalRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/professionals")
    public List<ProfessionalDTO> getProfessionals(){
        return professionalRepository.findAll().stream().map(ProfessionalDTO::new).collect(toList());
    }
}
