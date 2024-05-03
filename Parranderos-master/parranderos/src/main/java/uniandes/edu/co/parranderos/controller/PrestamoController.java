package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "redirect:/prestamo/new";
    }

    @GetMapping("/operacionprestamo/pagarCuota")
    public String PrestamoPagar(Model model) 
    {
        model.addAttribute("numeroprestamo", "");
        model.addAttribute("nuevoMonto", 0);
        return "operacionprestamo";
    }

    @GetMapping("/operacionprestamo/{numeroprestamo}/{monto}/edit/save")
    public String PrestamoPagarCuotaGet(@PathVariable("numeroprestamo") String numeroprestamo, @PathVariable("monto") Integer montoNuevo)
    {
        prestamoRepository.actualizarPrestamoPagarCuota(numeroprestamo, montoNuevo);
        return "redirect:/";
    }

    @PostMapping("/prestamo/{numeroprestamo}/{monto}/edit/save")
    public String PrestamoPagarCuota(@PathVariable("numeroprestamo") String numeroprestamo, @PathVariable("monto") Integer montoNuevo)
    {
        prestamoRepository.actualizarPrestamoPagarCuota(numeroprestamo, montoNuevo);
        return "redirect:/";
    }
}    