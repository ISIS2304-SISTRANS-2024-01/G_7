package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;


import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.OperacionesCuenta;
import com.example.demo.modelo.PuntoAtencion;
import com.example.demo.repositorio.CuentaRepository;

@Slf4j
@Controller
public class CuentaController 
{

    @Autowired
    private CuentaRepository cuentaRepository;

    // Crear Punto Atencion


    public Cuenta obtenerCuentaPorNumero(String numeroCuenta) 
    {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

    

    // Crear Cuenta

    @PostMapping("/cuenta/new/save")
    public String insertarCuenta(@RequestBody Cuenta cuenta) 
    {
        try 
        {
            if (cuenta.getOperaciones_cuenta() == null) 
            {
                cuenta.setOperaciones_cuenta(new ArrayList<>());
            }
            cuentaRepository.save(cuenta);
            return "confirmacionCuentaCreada";
        } 
        catch (Exception e) 
        {
            log.error("Error al insertar la cuenta", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al insertar la cuenta", e);
        }
    }

    @GetMapping("/cuenta/new")
    public String cuentaForm(Model model) 
    {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNueva";
    }


    // Cerrar cuenta

    @GetMapping("/cuenta/closed")
    public String cerrarCuenta(Model model)
    {
        model.addAttribute("numeroCuenta", new Cuenta());
        return "cuentaCerrada";
    }

    @PostMapping("/operacioncuenta/{numeroCuenta}/close")
    public String operacionCerrarCuenta(@PathVariable("numeroCuenta") String numeroCuenta) 
    {
        cuentaRepository.cerrarCuenta(numeroCuenta);
        return "confirmacionCuentaCerrada";
    }

    // Desactivar cuenta

    @GetMapping("/cuenta/deactivated")
    public String desactivarCuenta(Model model)
    {
        model.addAttribute("numeroCuenta", new Cuenta());
        return "cuentaDesactivada";
    }

    @PostMapping("/operacioncuenta/{numeroCuenta}/deactivate")
    public String operacionDesactivarCuenta(@PathVariable("numeroCuenta") String numeroCuenta) 
    {
        cuentaRepository.desactivarCuenta(numeroCuenta);
        return "confirmacionCuentaDesactivada";
    }




    //Insertar Punto Atencion
    
    @GetMapping("/punto/new")
    public String puntoForm(Model model) {
        model.addAttribute("puntoAtencion", new PuntoAtencion());
        return "crearPuntoAtencion";
    }

    // @PostMapping("/cuenta/{idCuenta}/operacion/{tipoOperacion}/puntoatencion/agregar")
    // public String insertarPuntoAtencion(@ModelAttribute PuntoAtencion puntoAtencion, @PathVariable String idCuenta, @PathVariable String tipoOperacion) 
    // {
    //     cuentaRepository.insertarPuntoAtencion(tipoOperacion, 1);
    //     return "redirect:/confirmacionPuntoCreado";
    // }


    @PostMapping("/cuenta/{idCuenta}/operacion/{tipoOperacion}/puntoatencion/agregar")
    public String insertarPuntoAtencion(@RequestParam("tipo") String tipo, @RequestParam("operaciones_validas") List<String> operacionesValidas, @RequestParam("oficina") int oficina)
    {
        // Crea un objeto PuntoAtencion con los parámetros recibidos
        PuntoAtencion puntoAtencion = new PuntoAtencion();
        puntoAtencion.setTipo(tipo);
        puntoAtencion.setOperaciones_validas(operacionesValidas);
        puntoAtencion.setOficina(oficina);

    // Aquí deberías tener lógica para asociar el punto de atención con la cuenta específica
        cuentaRepository.insertarPuntoAtencion(puntoAtencion);
        return "redirect:/confirmacionPuntoCreado";
    }


    @GetMapping("/confirmacionPuntoCreado")
    public String confirmacionPuntoCreado() 
    {
        return "confirmacionPuntoCreado";
    }
}
