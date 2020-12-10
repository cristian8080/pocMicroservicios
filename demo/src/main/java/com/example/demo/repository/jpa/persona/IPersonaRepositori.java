package com.example.demo.repository.jpa.persona;

import com.example.demo.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositori extends JpaRepository<Persona, Integer> {
}
