package com.backend.antiguedades.epocaAntiguedad.domain;

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
@Table(name = "epocaAntiguedad")
@Getter
@Setter
@NoArgsConstructor
public class EpocaAntiguedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "epoca", columnDefinition = "varchar(100)", nullable = false)
    public String epoca;





}
