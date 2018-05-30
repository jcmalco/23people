package com.people.springbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.springbootrestapi.model.Persona;
import com.people.springbootrestapi.repository.PersonaRepository;

@Service
public class PersonaDAO {
	
	@Autowired
	PersonaRepository personaRepository;
	
	/*Guardar persona*/
	
	public Persona save(Persona per) {
		return personaRepository.save(per);
	}
	
	/*Buscar todas las personas*/
	
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}
	
	/*Obtener persona por id*/
	
	public Persona findOne(Integer perid) {
		return personaRepository.findOne(perid);
	}
	
	/*Borrar persona*/
	
	public void delete(Persona per) {
		personaRepository.delete(per);
	}


}
