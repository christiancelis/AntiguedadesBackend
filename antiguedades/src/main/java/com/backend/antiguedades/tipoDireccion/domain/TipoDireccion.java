package com.backend.antiguedades.tipoDireccion.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipodireccion")
@Setter
@Getter
@NoArgsConstructor
public class TipoDireccion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tipo", columnDefinition = "VARCHAR(200)", nullable = false)
    private String tipo;

}
