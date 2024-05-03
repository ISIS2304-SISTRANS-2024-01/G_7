package uniandes.edu.co.parranderos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.parranderos.modelo.OperacionCuenta;

@Controller
public class ConsultarOperacionCuentaController {

    @GetMapping("/ConsultasOperacionesCuenta")
    public String consultasOperacionCuentaForma(Model model)
    {
        model.addAttribute("consultasOperacionesCuenta", new OperacionCuenta());
        return "consultasOperacionesCuenta";
    }

}
