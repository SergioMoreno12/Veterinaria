package com.example.demo.Model;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String especie;

    @Column(nullable = false, length = 60)
    private String raza;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false, length = 150)
    private String duenio;

    @Column(length = 20)
    private String telefono;
}