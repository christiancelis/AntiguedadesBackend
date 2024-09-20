package com.backend.antiguedades.pais.infrastructure;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.antiguedades.pais.domain.Pais;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pais")
public class PaisController {
    
    @Autowired
    private PaisServiceImp paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> listarPagos() {
        List<Pais> listaPaises = paisService.findAll();
        return ResponseEntity.ok(listaPaises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> obtenerPais(@PathVariable Long id) {
        Optional<Pais> pais = paisService.findById(id);
        if(pais.isPresent()){
            return  ResponseEntity.ok(pais.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/crear")
    public ResponseEntity<Pais> crearPais(@RequestBody Pais pais) {
        return ResponseEntity.ok(paisService.save(pais));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pais> actualizarPais(@PathVariable Long id, @RequestBody Pais pais) {
        if (!paisService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paisService.update(id, pais));
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
