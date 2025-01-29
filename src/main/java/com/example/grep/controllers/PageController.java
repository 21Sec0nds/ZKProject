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
        return "redirect:/presupuestos";
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

    @GetMapping("/presupuestos/login")
    public String presupuestosLogin() {
        return "login";
    }
}