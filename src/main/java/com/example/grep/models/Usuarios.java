package com.example.grep.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private String id_usuario;

    @Column(name = "NOMBRE_USUARIO", nullable = false)
    private String nombre_usuario;

    @Column(name = "PASSWORD", nullable = true)
    private String password;

    // Constructor con parámetros
    public Usuarios(String idUsuario, String nombreUsuario, String password) {
        this.id_usuario = idUsuario;
        this.nombre_usuario = nombreUsuario;
        this.password = password;
    }

    // Constructor vacío
    public Usuarios() {}

    // Getters y setters
    public String getIdUsuario() { return id_usuario; }
    public void setIdUsuario(String idUsuario) { this.id_usuario = idUsuario; }

    public String getNombreUsuario() { return nombre_usuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombre_usuario = nombreUsuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
