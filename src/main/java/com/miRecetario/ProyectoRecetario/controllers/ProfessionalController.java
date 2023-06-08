package com.miRecetario.ProyectoRecetario.controllers;

import com.miRecetario.ProyectoRecetario.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfessionalController {

    @Autowired
    ProfessionalRepository professionalRepository;
}
