package com.example.demo.Repository;

import com.example.demo.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Buscar mascotas por especie (ej: "Perro", "Gato")
    List<Mascota> findByEspecie(String especie);

    // Buscar mascotas por nombre del dueño
    List<Mascota> findByDuenioContainingIgnoreCase(String duenio);
}