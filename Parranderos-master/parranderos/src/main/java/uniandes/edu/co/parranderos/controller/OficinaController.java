package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.parranderos.modelo.Oficina;
import uniandes.edu.co.parranderos.repositorio.OficinaRepository;

@Controller
public class OficinaController {
    
    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficinas/new")
    public String usuarioForm(Model model) {
        model.addAttribute("oficina", new Oficina());
        return "oficinaNueva";
    }

    @PostMapping("/oficinas/new/save")
    public String usuarioGuardar(@ModelAttribute Oficina oficina) {
        oficinaRepository.insertarOficina(oficina.getNOMBRE(), oficina.getDIRECCION(), oficina.getNUMPUESTOSATENCION());
        return "redirect:/oficinas/new";
    }

}
