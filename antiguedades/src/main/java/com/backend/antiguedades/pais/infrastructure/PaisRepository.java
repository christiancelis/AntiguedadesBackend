package com.backend.antiguedades.pais.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.antiguedades.pais.domain.Pais;

@Repository
public interface PaisRepository extends  JpaRepository<Pais, Long> {

}
