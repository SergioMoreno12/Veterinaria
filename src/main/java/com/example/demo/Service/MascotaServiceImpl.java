package com.example.demo.Service;

import com.example.demo.DTO.MascotaDTO;
import com.example.demo.Model.Mascota;
import com.example.demo.Repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    // Convierte DTO → Entidad
    private Mascota toEntity(MascotaDTO dto) {
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setEdad(dto.getEdad());
        mascota.setPeso(dto.getPeso());
        mascota.setDuenio(dto.getDuenio());
        mascota.setTelefono(dto.getTelefono());
        return mascota;
    }

    @Override
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }

    @Override
    public List<Mascota> buscarPorEspecie(String especie) {
        return mascotaRepository.findByEspecie(especie);
    }

    @Override
    public Mascota guardar(MascotaDTO dto) {
        return mascotaRepository.save(toEntity(dto));
    }

    @Override
    public Mascota actualizar(Long id, MascotaDTO dto) {
        Mascota mascota = buscarPorId(id);
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setEdad(dto.getEdad());
        mascota.setPeso(dto.getPeso());
        mascota.setDuenio(dto.getDuenio());
        mascota.setTelefono(dto.getTelefono());
        return mascotaRepository.save(mascota);
    }

    @Override
    public void eliminar(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada con id: " + id);
        }
        mascotaRepository.deleteById(id);
    }
}