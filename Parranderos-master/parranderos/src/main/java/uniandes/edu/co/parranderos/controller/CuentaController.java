package uniandes.edu.co.parranderos.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.parranderos.repositorio.CuentaRepository;


//@RestController // Debo cambiarlo por @Controller cuando ya teng ala interfaz
@Controller
public class CuentaController {
    
    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model, String TIPO, Integer SALDOINICIAL, Integer SALDOFINAL, Integer DOCUMENTOIDENTIFICACIONNUMERO) {
        if (TIPO == null || SALDOINICIAL == null || SALDOFINAL == null || DOCUMENTOIDENTIFICACIONNUMERO == null) {
            model.addAttribute("cuentas", cuentaRepository.darCuentas());   
        }else{
            model.addAttribute("cuentas", cuentaRepository.darCuentaRFC1(TIPO, SALDOINICIAL, SALDOFINAL, DOCUMENTOIDENTIFICACIONNUMERO));
        }
        return "cuentas";
    }



}
