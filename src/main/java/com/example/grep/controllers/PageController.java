package com.example.grep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    //redirige a usuarios
    @GetMapping("/")
    public String homepage() {
        return "redirect:/usuarios";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/departamentos")
    public String departamentos() {
        return "departamentos";
    }

    @GetMapping("/finalidades")
    public String finalidades() {
        return "finalidades";
    }

    @GetMapping("/gastos")
    public String gastos() {
        return "gastos";
    }

    @GetMapping("/liquidaciones")
    public String liquidaciones() {
        return "liquidaciones";
    }

    @GetMapping("/presupuestos")
    public String presupuestos() {
        return "presupuestos";
    }

    @GetMapping("/tipoliquid")
    public String tipoEstadoLiqui() {
        return "tipoliquid";
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios";
    }

}
