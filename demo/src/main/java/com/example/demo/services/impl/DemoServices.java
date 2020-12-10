package com.example.demo.services.impl;

import com.example.demo.commons.utils.WebClientException;
import com.example.demo.model.dtos.PersonaDTO;
import com.example.demo.model.entities.Persona;
import com.example.demo.repository.jpa.persona.IPersonaRepositori;
import com.example.demo.repository.persona.IPersonaRepositoriFacade;
import com.example.demo.services.IDemoServices;
import org.modelmapper.ModelMapper;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemoServices implements IDemoServices {
    private final ModelMapper modelMapper;
    private final IPersonaRepositoriFacade personaRepositoriFacade;
    private final IPersonaRepositori personaRepositori;

    @Autowired
    public DemoServices(ModelMapper modelMapper, IPersonaRepositoriFacade personaRepositoriFacade, IPersonaRepositori personaRepositori) {
        this.modelMapper = modelMapper;
        this.personaRepositoriFacade = personaRepositoriFacade;
        this.personaRepositori = personaRepositori;
    }

    @Override
    public Optional<List<PersonaDTO>> consult() throws WebClientException {
        try {
            List<PersonaDTO> personaDTOS = new ArrayList<>();
            Optional<List<Persona>> personas = personaRepositoriFacade.consultAllPerson();
            if (!personas.isPresent()) {
                throw new WebClientException("1000", "no se encontraron datos");
            }
            for (Persona persona : personas.get()) {
                PersonaDTO dto = new PersonaDTO();
                dto = modelMapper.map(persona, PersonaDTO.class);
                personaDTOS.add(dto);
            }
            return Optional.ofNullable(personaDTOS);
        } catch (WebClientException e) {
            throw new WebClientException(e.getCode(), e.getMessage());
        } catch (SystemException ex) {
            throw new WebClientException("1000", ex.getMessage());
        }
    }

    @Override
    public Optional<PersonaDTO> createPerson(PersonaDTO persona) {
        try {
            Persona createPerson = new Persona();
            PersonaDTO responsePerson = new PersonaDTO();
            Optional<Persona> searchPerson = personaRepositoriFacade.searchNumberIden(persona.getNumeroIdentificacion());
            if (searchPerson.isPresent()) {
                throw new WebClientException("100.", "Ya Existe un usuario con el numero de identificacion");
            }
            createPerson = modelMapper.map(persona, Persona.class);
            personaRepositori.save(createPerson);
            responsePerson = modelMapper.map(createPerson, PersonaDTO.class);
            return Optional.of(responsePerson);
        } catch (WebClientException e) {
            throw new WebClientException(e.getCode(), e.getMessage());
        }
    }
}
