package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.parranderos.modelo.Bebida;
import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.repositorio.BebidaRepository;
import uniandes.edu.co.parranderos.repositorio.BebidaRepository.RespuestaInformacionBebidas;
import uniandes.edu.co.parranderos.repositorio.CuentaRepository;
import uniandes.edu.co.parranderos.repositorio.Tipo_bebidaRepository;


@Controller
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

        @GetMapping("/cuenta/nueva")
        public String cuentaForma(Model model){
            model.addAttribute("Cuenta", new Cuenta());
            return "Cuenta nueva";
        }
}