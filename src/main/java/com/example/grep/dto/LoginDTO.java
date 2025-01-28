package com.example.grep.dto;

public class LoginDTO {

    private int ID_USUARIO;
    private String NOMBRE_USUARIO;
    private int PASSWORD;

    // Constructor
    public LoginDTO(int ID_USUARIO, String NOMBRE_USUARIO, int PASSWORD) {
        this.ID_USUARIO = ID_USUARIO;
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
        this.PASSWORD = PASSWORD;
    }

    // Getters and Setters
    public int getIdUSER() {
        return ID_USUARIO;
    }

    public void setIdUSER(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getNOMBRE_USUARIO() {
        return NOMBRE_USUARIO;
    }

    public void setNOMBRE_USUARIO(String NOMBRE_USUARIO) {
        this.NOMBRE_USUARIO = NOMBRE_USUARIO;
    }

    public int getPASSWORD() {return PASSWORD;}

    public void setFinalidad(int PASSWORD) {this.PASSWORD = PASSWORD;}
}
