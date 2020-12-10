package com.example.demo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDTO {

    private Integer idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private Long numeroIdentificacion;
}
