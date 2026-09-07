package com.example.api_usuarios.Model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@Table(name = "USUARIOS")
public class Usuario {

    //id
    @Id
    private Long id_usuario;

    //datos personales
    @Column(name = "p_nombre", nullable = false)
    private String p_nombre;

    @Column(name = "s_nombre", nullable = false)
    private String s_nombre;

    @Column (name = "p_apellido", nullable = false)
    private String p_apellido;

    @Column (name = "s_apellido", nullable = false)
    private String s_apellido;

    //datos de contacto
    @Column(name = "correo_elec", nullable = false)
    private String correo_elec;

    @Column (name = "num_telefono", nullable = false)
    private String num_telefono;

    //seguridad
    @Column (name = "contrasena", nullable = false)
    private String contrasena;

    //Permiso de administrador
    @Column(name = "permiso_admin", nullable = false)
    private Boolean permiso_admin;

    //datos de ubicación
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_region", nullable = false)
    private Region region_usuario;



}
