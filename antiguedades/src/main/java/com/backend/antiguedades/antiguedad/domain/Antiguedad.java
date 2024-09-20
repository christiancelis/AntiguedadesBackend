package com.backend.antiguedades.antiguedad.domain;

import java.util.Set;

import com.backend.antiguedades.categoria.domain.Categoria;
import com.backend.antiguedades.epocaAntiguedad.domain.EpocaAntiguedad;
import com.backend.antiguedades.persona.domain.Persona;
import com.backend.antiguedades.sucursal.domain.Sucursal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "antiguedad")
@Getter
@Setter
@NoArgsConstructor
public class Antiguedad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", columnDefinition = "varchar(100)", nullable = false)
    public String nombre;

    @Column(name = "descripcion", nullable = false)
    public String  descripcion;

    @Column(name = "precio", nullable = false)
    public Double precio;

    @ManyToOne
    @JoinColumn(name="sucursal_id")
    public Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    public Categoria categoria;

    @ManyToOne
    @JoinColumn(name="epoca_id")
    public EpocaAntiguedad epocaAntiguedad;

    
    @ManyToMany
    @JoinTable
    (
        name = "historialpropiedad",
        joinColumns = @JoinColumn(name = "antiguedad_id"),
        inverseJoinColumns =  @JoinColumn(name = "persona_id")
    )
    private Set <Persona> personas;



}
