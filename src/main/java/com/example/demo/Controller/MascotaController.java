package com.example.demo.Controller;

import com.example.demo.DTO.MascotaDTO;
import com.example.demo.Model.Mascota;
import com.example.demo.Service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    // GET /api/mascotas
    @GetMapping
    public ResponseEntity<List<Mascota>> listar() {
        return ResponseEntity.ok(mascotaService.listarTodas());
    }

    // GET /api/mascotas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(mascotaService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /api/mascotas/especie/{especie}
    @GetMapping("/especie/{especie}")
    public ResponseEntity<List<Mascota>> buscarPorEspecie(@PathVariable String especie) {
        return ResponseEntity.ok(mascotaService.buscarPorEspecie(especie));
    }

    // POST /api/mascotas
    @PostMapping
    public ResponseEntity<Mascota> crear(@RequestBody MascotaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.guardar(dto));
    }

    // PUT /api/mascotas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody MascotaDTO dto) {
        try {
            return ResponseEntity.ok(mascotaService.actualizar(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/mascotas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            mascotaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}