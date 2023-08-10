package com.miRecetario.ProyectoRecetario.configuration;

import com.miRecetario.ProyectoRecetario.models.Patient;
import com.miRecetario.ProyectoRecetario.models.Professional;
import com.miRecetario.ProyectoRecetario.repositories.PatientRepository;
import com.miRecetario.ProyectoRecetario.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

//@configuration le indica a spring que debe crear un objeto de este tipo cuando se está iniciando la aplicación para que cuando se configure el módulo de spring
// utilice ese objeto ya creado
@Configuration

public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ProfessionalRepository professionalRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //Se otorga el tipo de autorizacion que puede tener una clase
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName-> {
            Optional<Professional> professional = professionalRepository.findByUser(inputName);
            Optional<Patient> patient = patientRepository.findByUser(inputName);
            if (professional.isPresent()) {
                return new User(professional.get().getUser(), professional.get().getPassword(),
                        AuthorityUtils.createAuthorityList("PROFESSIONAL"));
            } else if (patient.isPresent()) {
                return new User(patient.get().getUser(), patient.get().getPassword(),
                        AuthorityUtils.createAuthorityList("PATIENT"));
            } else {
                throw new UsernameNotFoundException("Unknown user: " + inputName);
            }
        });
    }
}
