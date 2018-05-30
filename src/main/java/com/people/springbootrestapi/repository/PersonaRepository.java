package com.people.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.people.springbootrestapi.model.Persona;
//import org.springframework.stereotype.Repository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
