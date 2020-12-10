package com.example.demo.repository.jpa.persona;

import com.example.demo.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonaRepositori extends JpaRepository<Persona, Integer> {

    @Query("Select perso from Persona perso where perso.numeroIdentificacion=:numeroIdentificacion")
    Optional<Persona> searchNumberIden(@Param("numeroIdentificacion") Long numeroIdentificacion);
}
