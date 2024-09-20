package com.backend.antiguedades.region.application;

import java.util.List;
import java.util.Optional;

import com.backend.antiguedades.region.domain.Region;

public interface IRegion {
    List<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region region);
    Region update(Long id, Region region);
    void delete(Long id);
}
