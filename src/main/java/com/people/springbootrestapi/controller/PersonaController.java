package com.people.springbootrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.people.springbootrestapi.dao.PersonaDAO;
import com.people.springbootrestapi.model.Persona;

@RestController
@RequestMapping("/rest")
public class PersonaController {
	
	@Autowired
	PersonaDAO personaDAO;
	
	/* para guardar una persona */
	@PostMapping("/personas")
	public Persona createPersona(@Valid @RequestBody Persona per) {
		return personaDAO.save(per);
	}
	
	/* obtener todas las personas */
	@GetMapping("/personas")
	public List<Persona> getAllPersonas() {
		return personaDAO.findAll();
	}
	
	/* obtener una persona por id */
	@GetMapping("/info/{id}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable(value="id") Integer perid ) {
		Persona per = personaDAO.findOne(perid);
		if(per == null) {
			return ResponseEntity.notFound().build();	
		}
		return ResponseEntity.ok().body(per);
	}
	
	/* actualizar persona por id */
	@PutMapping("/personas/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable(value="id") Integer perid, @Valid @RequestBody Persona perDetails) {
		Persona per = personaDAO.findOne(perid);
		if(per == null) {
			return ResponseEntity.notFound().build();	
		}
		
		per.setNombre(perDetails.getNombre());
		per.setApellido(perDetails.getApellido());
		
		Persona updatePersona = personaDAO.save(per);
		
		return ResponseEntity.ok().body(updatePersona);
		
	}
	
	/* borrar una persona */
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable(value="id") Integer perid) {
		Persona per = personaDAO.findOne(perid);
		if(per == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().build();
		
	}

}
