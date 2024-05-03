package uniandes.edu.co.parranderos.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.Cliente;
import uniandes.edu.co.parranderos.modelo.OperacionPrestamo;
import uniandes.edu.co.parranderos.repositorio.ClienteRepository;
import uniandes.edu.co.parranderos.repositorio.OperacionPrestamoRepository;

// @RestController
@Controller
public class OperacionPrestamoController 
{
    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;
    
    //PARA SELECT
    @GetMapping("/operacionprestamo")
    public String OperacionPrestamo(Model model)
    {
        model.addAttribute("operacionprestamo", operacionPrestamoRepository.darOperacionesPrestamos());
        return "operacionprestamo";
        // rseturn model.toString();
    }

    @GetMapping("/operacionprestamo/new")
    public String OperacionPrestamoForm(Model model)
    {
        model.addAttribute("operacionprestamo", new OperacionPrestamo());
        return "prestamoNuevo";
    }

    @GetMapping("/operacionprestamo/closed")
    public String OperacionPrestamoCerrar(Model model)
    {
        model.addAttribute("numeroprestamo", new OperacionPrestamo());
        return "operacionPrestamoCerrado";
    }

    @PostMapping("/operacionprestamo/{numeroprestamo}/close")
    public String operacionCerrar(@PathVariable("numeroprestamo") String numeroprestamo)
    {
        operacionPrestamoRepository.actualizarEstadoPrestamoACerrado(numeroprestamo);
        return "redirect:/operacionprestamo/new";
    }

    @GetMapping("/operacionprestamo/confirmacion")
    public String confirmacionCerrado()
    {
        return "confirmacionPrestamoCerrado";
    }


    @PostMapping("/operacionprestamo/{id}/new/save")
    public String operacionesPrestamoGuardar(@PathVariable("id") Cliente id, @ModelAttribute OperacionPrestamo operacionPrestamo)
    {
        operacionPrestamoRepository.actualizarPrestamo(id, operacionPrestamo.getNumeroprestamo(), operacionPrestamo.getPrestamo(), operacionPrestamo.getPrestamo(), operacionPrestamo.getId());
        return "redirect:/operacionprestamo/new";
    }

    @Autowired
    private ClienteRepository clienteRepository; 

    // PARA UPDATE
    @GetMapping("/operacionprestamo/{id}/edit")
    public String operacionesPrestamoEditarForm(@PathVariable("id") Cliente id, Model model)
    {
        OperacionPrestamo operacionPrestamo = operacionPrestamoRepository.darOperacionPrestamo(id);
        if (operacionPrestamo != null) 
        {
            model.addAttribute("operacionPrestamo", operacionPrestamo);
            return "operacionPrestamoEditar";
        }
        else
        {
            return "redirect:/operacionprestamo";
        }
    }


    @PostMapping("/operacionprestamo/{id}/edit/save")
    public String operacionesPrestamoEditarGuardar(@PathVariable("id") Cliente id, @ModelAttribute OperacionPrestamo operacionPrestamo)
    {
        operacionPrestamoRepository.actualizarPrestamo(id, operacionPrestamo.getNumeroprestamo(), operacionPrestamo.getPrestamo(), operacionPrestamo.getPrestamo(), operacionPrestamo.getId());
        return "redirect:/operacionprestamo";
    }

}
