package com.miRecetario.ProyectoRecetario;

import com.miRecetario.ProyectoRecetario.models.Patient;
import com.miRecetario.ProyectoRecetario.models.Professional;
import com.miRecetario.ProyectoRecetario.models.Recipe;
import com.miRecetario.ProyectoRecetario.repositories.PatientRepository;
import com.miRecetario.ProyectoRecetario.repositories.PersonRepository;
import com.miRecetario.ProyectoRecetario.repositories.ProfessionalRepository;
import com.miRecetario.ProyectoRecetario.repositories.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProyectoRecetarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoRecetarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PersonRepository personRepository, PatientRepository patientRepository, ProfessionalRepository professionalRepository,
									  RecipeRepository recipeRepository) {
		return (args) -> {

			/*Person person = new Person("german", "sopeña", "38103643");
			personRepository.save(person);
			Professional professional = new Professional("Vanesa", "Bianco", "202020","Medico","mbianco","2020");
			professionalRepository.save(professional);*/

			Patient patient1 = new Patient("german", "sopeña", "38103643", "gSope", "123456", "Osam", "2145", "2477399209" );
			Patient patient2 = new Patient("esteban", "sopeña", "25698742", "eSope","654321", "sancor", "2136549", "2477399210" );
			patientRepository.save(patient1);
			patientRepository.save(patient2);


			Professional professional1 = new Professional("Laura", "Forni", "21023", "Geriatria", "LForni","658943");
			Professional professional2 = new Professional("Vanesa", "Bianco", "136694", "Medica Clinica", "VBianco","32164");
			professionalRepository.save(professional1);
			professionalRepository.save(professional2);

			Recipe recipe1 = new Recipe(LocalDateTime.now(), false, professional1, patient1);
			recipeRepository.save(recipe1);

		};
	}

}
