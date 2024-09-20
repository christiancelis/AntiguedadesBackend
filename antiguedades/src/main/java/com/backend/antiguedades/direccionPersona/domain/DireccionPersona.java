package com.backend.antiguedades.direccionPersona.domain;


import com.backend.antiguedades.persona.domain.Persona;
import com.backend.antiguedades.tipoDireccion.domain.TipoDireccion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direccionpersona")
@Setter
@Getter
@NoArgsConstructor
public class DireccionPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion", columnDefinition = "VARCHAR(200)", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name="persona_id")
    public Persona persona;

    @ManyToOne
    @JoinColumn(name="tipodireccion_id")
    public TipoDireccion tipodireccion;

    
}
