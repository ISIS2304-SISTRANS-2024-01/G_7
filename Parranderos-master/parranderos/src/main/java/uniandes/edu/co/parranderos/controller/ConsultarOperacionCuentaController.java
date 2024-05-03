package uniandes.edu.co.parranderos.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.OperacionCuenta;
import uniandes.edu.co.parranderos.repositorio.OperacionCuentaRepository;
import uniandes.edu.co.parranderos.repositorio.OperacionCuentaRepository.RespuestaInformacionCuenta;

@Controller
public class ConsultarOperacionCuentaController {

    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @GetMapping("/ConsultasOperacionesCuenta")
    public String consultasOperacionCuentaForma() {
        return "consultasOperacionesCuenta";
    }

    @PostMapping("/ConsultasOperacionesCuenta")
    public String consultasOperacionCuenta(@RequestParam("accountNumber") Integer accountNumber, 
                                           @RequestParam("submitAction") String action, Model model) {
        Collection<RespuestaInformacionCuenta> operaciones;
        if ("Serializable".equals(action)) {
            operaciones = operacionCuentaRepository.darInformacionOperacionesCuentaSE(accountNumber);
        } else { // Assume "Read Commited"
            operaciones = operacionCuentaRepository.darInformacionOperacionesCuentaRC(accountNumber);
        }
        model.addAttribute("operaciones", operaciones);
        return "consultasOperacionesCuenta";
    }

}
