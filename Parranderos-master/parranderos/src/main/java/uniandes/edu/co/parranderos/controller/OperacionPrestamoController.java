package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.parranderos.modelo.OperacionPrestamo;

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

        return "pretamoNuevo";
    }

    // PARA UPDATE
    @GetMapping("/operacionprestamo/{id}/edit")
    public String operacionesPrestamoEditarForm(@PathVariable("id") Integer id, Model model)
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
    public String operacionesPrestamoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute OperacionPrestamo operacionPrestamo)
    {
        operacionPrestamoRepository.actualizarPrestamo(id, operacionPrestamo.getNumeroprestamo(), operacionPrestamo.getPrestamo(), operacionPrestamo.getPrestamo(), operacionPrestamo.getId());

        return "redirect:/operacionprestamo";
    }
}
