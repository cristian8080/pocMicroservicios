package com.example.demo.web.rest;

import com.example.demo.commons.domains.response.builder.ResponseBuilder;
import com.example.demo.commons.utils.WebClientException;
import com.example.demo.model.dtos.PersonaDTO;
import com.example.demo.services.IDemoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("demo/api/")
public class DemoClass {

    @Autowired
    private IDemoServices demoServices;

    @GetMapping("consultar")
    public ResponseEntity<?> consultar(HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();
        try {
            Optional<List<PersonaDTO>> personaDTOS = demoServices.consult();
            if (personaDTOS.isPresent()) {
                response.withStatus(HttpStatus.OK)
                        .withBusinessStatus("200")
                        .withResponse(personaDTOS.get());
            }
        } catch (WebClientException e) {
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withMessage(e.getMessage());
        } finally {
            return response
                    .withPath(request.getRequestURI())
                    .buildResponse();
        }

    }

    @PostMapping("insetar")
    public ResponseEntity<?> insertar(@RequestBody PersonaDTO persona, HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();
        try {
            Optional<PersonaDTO> createPerson = demoServices.createPerson(persona);
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus("200")
                    .withResponse(createPerson.get());

        } catch (WebClientException e) {
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withMessage(e.getMessage());
        } catch (Exception e) {
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withMessage(e.getMessage());
        } finally {
            return response
                    .withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @PutMapping("actualizar")
    public ResponseEntity<?> actualizar() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PatchMapping("actualizar")
    public ResponseEntity<?> actualizardos() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
