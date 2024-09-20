package com.backend.antiguedades.region.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.antiguedades.region.application.IRegion;
import com.backend.antiguedades.region.domain.Region;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RegionServiceImpl implements IRegion{

     @Autowired
    public  RegionRepository regionRepository;


    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return  regionRepository.findById(id);

    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region update(Long id, Region region) {
         if (!regionRepository.existsById(id)) {
            throw new EntityNotFoundException("Region no encontrado con id: " + id);
        }
        return regionRepository.save(region);
    }

    @Override
    public void delete(Long id) {
        if (!regionRepository.existsById(id)) {
            throw new EntityNotFoundException("Region no encontrado con id: " + id);
        }
        regionRepository.deleteById(id);
    }

}
