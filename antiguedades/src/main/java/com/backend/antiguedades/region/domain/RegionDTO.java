package com.backend.antiguedades.region.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegionDTO {

    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;
    
    @NotEmpty(message = "El id del pais no puede ser vacio")
    private Long PaisId;
}
