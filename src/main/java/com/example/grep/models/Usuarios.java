package com.example.grep.models;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private String id_usuario;

    @Column(name = "NOMBRE_USUARIO", nullable = false)
    private String nombreUsuario;

    @Column(name = "PASSWORD", nullable = true)
    private String password;


    public Usuarios(String idUsuario, String nombreUsuario, String password) {
        this.id_usuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }


    public Usuarios() {}


    public String getIdUsuario() { return id_usuario; }
    public void setIdUsuario(String idUsuario) { this.id_usuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
