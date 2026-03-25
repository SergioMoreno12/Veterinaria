package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MascotaDTO {

    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private double peso;
    private String duenio;
    private String telefono;
}