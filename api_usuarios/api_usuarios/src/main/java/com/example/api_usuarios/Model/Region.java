package com.example.api_usuarios.Model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;


@Entity
@Data
@NoArgsConstructor
@Table(name = "REGIONES")
public class Region {


    @Id 
    private Long id_region;

    @Column(name = "nombre_region", nullable = false)
    private String nombre_region;



}
