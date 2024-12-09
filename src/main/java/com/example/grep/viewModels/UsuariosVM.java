package com.example.grep.viewModels;

import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import java.util.List;


public class UsuariosVM {

    @WireVariable
    private UsuariosService usuarioService;
//    private UsuariosService usuarioService = (UsuariosService) SpringUtil.getBean("usuarioService");


    private List<Usuarios> usuarios;
    private String idUsuario;
    private String nombreUsuario;
    private String password;

    @Init
    public void init() {
        usuarios = new ListModelList<>(usuarioService.getAllUsuarios());
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Init
    public void init() {
        usuarios = new ListModelList<>(usuarioService.getAllUsuarios());
    }

    @Command
    @NotifyChange({"usuarios", "idUsuario", "nombreUsuario", "password"})
    public void guardarUsuario() {

        //Validacion
        if (idUsuario == null || idUsuario.trim().isEmpty() ||
                nombreUsuario == null || nombreUsuario.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {

            Messagebox.show("Todos los campos son obligatorios.", "Error", Messagebox.OK, Messagebox.ERROR);
            return;
        }


        Usuarios nuevoUsr = new Usuarios();
        nuevoUsr.setIdUsuario(idUsuario.trim());
        nuevoUsr.setNombreUsuario(nombreUsuario.trim());
        nuevoUsr.setPassword(password.trim());

        usuarioService.saveUsuario(nuevoUsr);
        usuarios.add(nuevoUsr);

        idUsuario = "";
        nombreUsuario = "";
        password = "";
    }

}
