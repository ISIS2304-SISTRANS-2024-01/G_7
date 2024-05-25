package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.Cuenta;
import com.example.demo.repositorio.CuentaRepository;

@RestController
public class CuentaController 
{

    @Autowired
    private CuentaRepository cuentaRepository;

    @PostMapping("/cuentas")
    public String insertarCuenta(@RequestBody Cuenta cuenta) // no se si RequestBody o ModelAttribute
    {
        cuentaRepository.insertarCuenta(cuenta.getTipo(), cuenta.getEstado(), cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getFecha_ultima_transaccion(), cuenta.getFecha_creaccion());

        return "redirect:/cuenta/new";
    }

    @PostMapping("/operacioncuenta/{numeroCuenta}/close")
    public String operacionCerrarCuenta(@PathVariable("numeroCuenta") String numeroCuenta)
    {
        cuentaRepository.CerrarCuenta(numeroCuenta);
        return "confirmacionCuentaCerrada";
    }

    @PostMapping("/operacioncuenta/{numeroCuenta}/deactivate")
    public String operacionDesactivarCuenta(@PathVariable("numeroCuenta") String numeroCuenta)
    {
        cuentaRepository.DesactivarCuenta(numeroCuenta);
        return "confirmacionCuentaDesactivada";
    }

}