package com.backend.antiguedades.medioPago.domain;

import java.util.Set;

import com.backend.antiguedades.transaccion.domain.Transaccion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mediopago")
@Setter
@Getter
@NoArgsConstructor
public class MedioPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medioDePago", columnDefinition = "VARCHAR(255)", nullable = false)
    private String mediodepago;

    @JsonIgnoreProperties({"mediosPago", "handler", "hibernateLazyInitializer"})
    @ManyToMany(mappedBy = "mediosPago")
    private Set<Transaccion> transacciones;
    

}
