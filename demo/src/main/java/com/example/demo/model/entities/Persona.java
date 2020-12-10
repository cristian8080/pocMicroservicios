package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author CQUINTERO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Basic(optional = false)
    @Column(name = "nombre_persona")
    private String nombrePersona;

    @Basic(optional = false)
    @Column(name = "apellido_persona")
    private String apellidoPersona;

    @Basic(optional = false)
    @Column(name = "numero_identificacion")
    private Long numeroIdentificacion;


}
