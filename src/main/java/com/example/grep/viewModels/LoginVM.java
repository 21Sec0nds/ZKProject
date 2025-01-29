package com.example.grep.viewModels;

import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class LoginVM {

    @WireVariable
    private UsuariosService usuarioService;

    private String username;
    private String password;
    private String message;

    // This method runs once after page load
    /*@AfterCompose
    public void init0() {
        // If the user is already logged in, redirect them to the main page
        if (isUserLoggedIn()) {
            Executions.sendRedirect("/presupuestos");
        }
    }

    // Helper method to check if the user is logged in
    private boolean isUserLoggedIn() {
        Session session = Executions.getCurrent().getSession();
        return session.getAttribute("LoggedInUser") != null;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    @NotifyChange("message")
    @Command
    public void login() {
        // Retrieve the user from the database by username
        Usuarios usuario = usuarioService.getUsuarioByname(username);

        // Check if the user exists and password matches
        if (usuario != null && usuario.getPassword().equals(password)) {
            // Set user in session
            Session session = Executions.getCurrent().getSession();
            session.setAttribute("LoggedInUser", usuario);

            message = "Login successful!";
            Executions.sendRedirect("/presupuestos");
        } else {
            message = "Invalid username or password!";
        }
    }
}
