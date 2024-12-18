package com.example.grep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/")
    public String homepage() {
        return "redirect:/usuarios";
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

    @GetMapping("/presupuestos/details")
    public String presupuestosDetails(@RequestParam("presupuestoId") int presupuestoId, Model model) {
        model.addAttribute("presupuestoId", presupuestoId);
        return "details";
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
