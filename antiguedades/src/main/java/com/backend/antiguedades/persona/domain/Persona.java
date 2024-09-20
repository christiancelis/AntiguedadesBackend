package com.backend.antiguedades.persona.domain;

import java.util.List;

import com.backend.antiguedades.antiguedad.domain.Antiguedad;
import com.backend.antiguedades.genero.domain.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
public class Persona {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombre", columnDefinition = "varchar(100)", nullable = false)
    public String nombre;

    @Column(name = "apellido", columnDefinition = "varchar(100)", nullable = false)
    public String apellido;

    @Column(name = "edad", nullable = false)
    public int edad;

    @ManyToOne
    @JoinColumn(name="genero_id")
    public Genero genero;
    
    @ManyToMany(mappedBy = "personas")
    private List<Antiguedad> antiguedades;

}
