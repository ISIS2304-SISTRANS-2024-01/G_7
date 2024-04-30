package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.parranderos.modelo.PuntosAtencion;
import uniandes.edu.co.parranderos.repositorio.PuntosAtencionRepository;

@Controller
public class PuntosAtencionController {
    
    @Autowired
    private PuntosAtencionRepository puntosAtencionRepository;


    @GetMapping("/puntos/new")
    public String puntoForm(Model model) {
        model.addAttribute("puntosAtencion", new PuntosAtencion());
        return "puntoNuevo";
    }

    @PostMapping("/puntos/new/save")
    public String puntoGuardar(@ModelAttribute PuntosAtencion puntosAtencion) {
        puntosAtencionRepository.insertarPuntoAtencion(puntosAtencion.getTIPO(), puntosAtencion.getLOCALIZACION()); //TO-DO: anadirle el atributo que puede ser nulo
        return "redirect:/puntos/new";
    }

    @GetMapping("/puntos/delete")
    public String puntosEliminarForm(Model model){
        model.addAttribute("ID", 0);
        return "puntoEliminar";
    }

    @GetMapping("/puntos/{id}/delete")
    public String puntoEliminar(@PathVariable("id") int id){
        System.out.println("Eliminando punto de atencion con id: " + id);
        puntosAtencionRepository.eliminarPuntoAtencion(id);
        return "redirect:/puntos/new";
    }

}
