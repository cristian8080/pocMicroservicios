package com.example.demo.repository.persona;

import com.example.demo.commons.utils.WebClientException;
import com.example.demo.model.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaRepositoriFacade {
    Optional<List<Persona>> consultAllPerson() throws WebClientException;

    Optional<Persona> searchNumberIden(Long numeroIdentificacion);
}
