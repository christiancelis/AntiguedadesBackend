package com.backend.antiguedades.region.infrastructure;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.antiguedades.pais.domain.Pais;
import com.backend.antiguedades.pais.infrastructure.PaisServiceImp;
import com.backend.antiguedades.region.domain.Region;
import com.backend.antiguedades.region.domain.RegionDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired 
    private  RegionServiceImpl regionService;

    @Autowired 
    private PaisServiceImp paisService;


    @GetMapping
    public ResponseEntity<List<Region>> listarRegiones() {
        List<Region> listaRegiones = regionService.findAll();
        return ResponseEntity.ok(listaRegiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> obtenerRegion(@PathVariable Long id) {
        Optional<Region> region = regionService.findById(id);
        if(region.isPresent()){
            return  ResponseEntity.ok(region.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @Transactional
    @PostMapping("/crear")
    public ResponseEntity<Region> crearRegion(@Valid @RequestBody RegionDTO regionDTO, BindingResult result) {

        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        
        Optional <Pais> paisCreado = paisService.findById(regionDTO.getPaisId());
        if(!paisCreado.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        Region region = new Region();
        region.setNombre(regionDTO.getNombre());
        region.setPais(paisCreado.get());

        return ResponseEntity.ok().body(regionService.save(region));
    }

    @Transactional
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Region> actualizarRegion(@PathVariable Long id,@Valid @RequestBody RegionDTO regionDTO ,BindingResult result) {
       
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        Optional <Pais> paisCreado = paisService.findById(regionDTO.getPaisId());
        if(!paisCreado.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        Optional <Region>  region = regionService.findById(id);

        if (!region.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Region reg = region.get();
        reg.setNombre(regionDTO.getNombre());
        reg.setPais(paisCreado.get());
        return ResponseEntity.ok(regionService.update(id, reg));
    }

    @Transactional
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPais(@PathVariable Long id) {
        if (paisService.findById(id).isPresent()) {
            paisService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

                                                  
}
