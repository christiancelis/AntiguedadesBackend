package com.backend.antiguedades.region.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.antiguedades.region.domain.Region;

@Repository
public interface RegionRepository extends  JpaRepository<Region, Long> {
    

}
