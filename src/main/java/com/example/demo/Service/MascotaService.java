package com.example.demo.Service;

import com.example.demo.DTO.MascotaDTO;
import com.example.demo.Model.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodas();

    Mascota buscarPorId(Long id);

    List<Mascota> buscarPorEspecie(String especie);

    Mascota guardar(MascotaDTO dto);

    Mascota actualizar(Long id, MascotaDTO dto);

    void eliminar(Long id);
}