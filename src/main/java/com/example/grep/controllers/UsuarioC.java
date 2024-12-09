//package com.example.grep.controllers;
//
//import com.example.grep.models.Usuarios;
//import com.example.grep.services.UsuariosService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.zkoss.zk.ui.event.Event;
//import org.zkoss.zk.ui.select.SelectorComposer;
//import org.zkoss.zk.ui.select.annotation.Listen;
//import org.zkoss.zk.ui.select.annotation.Wire;
//import org.zkoss.zul.Button;
//import org.zkoss.zul.ListModelList;
//import org.zkoss.zul.Textbox;
//import org.zkoss.zul.Window;
//
//
//import java.util.List;
//
//
//@Controller
//public class UsuarioC  extends SelectorComposer<Window> {
//
//    @Autowired
//    private UsuariosService usuarioService;
//
//    private List<Usuarios> usuarios;
//
//    @Wire
//    private Textbox idUsuario;
//    @Wire
//    private Textbox nombreUsuario;
//    @Wire
//    private Textbox password;
//    @Wire
//    private Button btn;
//
//
//    // Endpoint para listar usuarios
//    @GetMapping("/usuarios")
//    public String listarUsuarios(Model model) {
//        usuarios = usuarioService.getAllUsuarios();
//        ListModelList<Usuarios> listaVista = new ListModelList<>(usuarios);  // Convertir a ListModelList
//        model.addAttribute("usuarios", listaVista); // Agregar los datos al modelo
//        return "usuarios";
//    }
//
//    @Listen("onClick = #btnCrear")
//    public String guardar(Event event){
//        System.out.println("hola kev");
//        if (usuarioService == null) {
//            throw new IllegalStateException("usuarioService no fue inyectado correctamente.");
//        }
//
//        String idUsr= idUsuario.getValue();
//        String nombreUsr= nombreUsuario.getValue();
//        String passwordUsr= password.getValue();
//
//        Usuarios nuevoUsr= new Usuarios();
//        nuevoUsr.setIdUsuario(idUsr.trim()); // Aseguramos que no tenga espacios en blanco
//        nuevoUsr.setNombreUsuario(nombreUsr.trim());
//        nuevoUsr.setPassword(passwordUsr.trim());
//
//        usuarioService.saveUsuario(nuevoUsr);
//
//        usuarios.add(nuevoUsr);
//        usuarios = new ListModelList<>(usuarios);
//
//        // Redirigir a la lista de usuarios
//        return "redirect:/usuarios";
//    }
//
//}
