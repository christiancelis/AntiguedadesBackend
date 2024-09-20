package com.backend.antiguedades.pais.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.antiguedades.pais.application.IPais;
import com.backend.antiguedades.pais.domain.Pais;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaisServiceImp implements IPais{

    @Autowired
    public  PaisRepository paisRepository;


    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Optional<Pais> findById(Long id) {
       return paisRepository.findById(id);
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public Pais update(Long id, Pais pais) {
        if (!paisRepository.existsById(id)) {
            throw new EntityNotFoundException("Pais no encontrado con id: " + id);
        }
        return paisRepository.save(pais);
    }

    @Override
    public void delete(Long id) {
         if (!paisRepository.existsById(id)) {
            throw new EntityNotFoundException("Pais no encontrado con id: " + id);
        }
        paisRepository.deleteById(id);
    }
    
}
