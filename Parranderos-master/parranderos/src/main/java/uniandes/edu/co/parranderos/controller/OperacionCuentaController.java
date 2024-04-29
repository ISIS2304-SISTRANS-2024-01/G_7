package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.modelo.OperacionCuenta;
import uniandes.edu.co.parranderos.repositorio.CuentaRepository;
import uniandes.edu.co.parranderos.repositorio.OperacionCuentaRepository;

@Controller
public class OperacionCuentaController {

    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

        @GetMapping("/operacionCuenta/nueva")
        public String operacionCuentaForma(Model model){
            model.addAttribute("OperacionCuenta", new OperacionCuenta());
            return "OperacionCuenta nueva";
        }
}
