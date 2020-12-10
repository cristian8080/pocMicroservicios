package com.example.demo.repository.persona.impl;

import com.example.demo.commons.utils.WebClientException;
import com.example.demo.model.entities.Persona;
import com.example.demo.repository.jpa.persona.IPersonaRepositori;
import com.example.demo.repository.persona.IPersonaRepositoriFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonaRepositoriFacade implements IPersonaRepositoriFacade {
    private final IPersonaRepositori personaRepositori;

    @Autowired
    public PersonaRepositoriFacade(IPersonaRepositori personaRepositori) {
        this.personaRepositori = personaRepositori;
    }

    @Override
    public Optional<List<Persona>> consultAllPerson() throws WebClientException {
        try {
            List<Persona> personas = personaRepositori.findAll();
            if (personas.size()>0){
                return Optional.of(personas);
            }else {
                throw new WebClientException("1000", "no se encontraron registros");
            }
        }catch (Exception e){
            throw new WebClientException("1000", e.getMessage());
        }
    }
}
