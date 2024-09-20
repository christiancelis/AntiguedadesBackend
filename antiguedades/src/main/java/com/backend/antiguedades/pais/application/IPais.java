package com.backend.antiguedades.pais.application;

import java.util.List;
import java.util.Optional;

import com.backend.antiguedades.pais.domain.Pais;

public interface IPais {
    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Pais save(Pais pais);
    Pais update(Long id, Pais pais);
    void delete(Long id);
}
