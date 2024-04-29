package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.parranderos.modelo.Prestamo;
import uniandes.edu.co.parranderos.modelo.PrestamoPK;
import uniandes.edu.co.parranderos.repositorio.PrestamoRepository;

//@RestController
@Controller
public class PrestamoController 
{
    @Autowired
    private PrestamoRepository prestamoRepository;

    //PARA SELECT
    @GetMapping("/prestamo")
    public String prestamo(Model model )
    {
        model.addAttribute("prestamo", prestamoRepository.darPrestamos());
        
        return "prestamo";
        // return model.toString();
    }

    @GetMapping("/prestamo/new")
    public String prestamoForm(Model model)
    {
        model.addAttribute("prestamo", new Prestamo());

        return "prestamoNuevo";
    }

    //PARA INSERT
    @PostMapping("/prestamo/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo, @ModelAttribute PrestamoPK prestamoPK)
    {
        prestamoRepository.insertarPrestamo(prestamoPK.getIdprestamo(), prestamoPK.getTipoprestamo(), prestamo.getEstado(), prestamo.getMonto(), prestamo.getIntereses(), prestamo.getNumcuotas(), prestamo.getMespago(), prestamo.getValorcuota());

        return "/redirect:/prestamo";
    }
}
