package com.backend.antiguedades.transaccion.domain;

import java.util.Date;
import java.util.Set;

import com.backend.antiguedades.medioPago.domain.MedioPago;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "transaccion")
@Setter
@Getter
@NoArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechatransaccion", columnDefinition = "VARCHAR(255)", nullable = false)
    private Date fechaTransaccion;

    @ManyToMany
    @JoinTable
    (
        name = "transaccionmediopago",
        joinColumns = @JoinColumn(name = "transaccion_id"),
        inverseJoinColumns =  @JoinColumn(name = "mediopago_id")
    )
    private Set <MedioPago> mediosPago;
    
}
