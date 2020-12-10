package com.example.demo.services;

import com.example.demo.commons.utils.WebClientException;
import com.example.demo.model.dtos.PersonaDTO;

import java.util.List;
import java.util.Optional;

public interface IDemoServices {
    Optional<List<PersonaDTO>> consult() throws WebClientException;
}
