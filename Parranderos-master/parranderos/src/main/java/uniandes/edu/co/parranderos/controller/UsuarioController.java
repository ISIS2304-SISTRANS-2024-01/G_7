package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.parranderos.modelo.Usuario;
import uniandes.edu.co.parranderos.repositorio.UsuarioRepository;


//@RestController // Debo cambiarlo por @Controller cuando ya teng ala interfaz
@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        // Aqui podria insertar el usuario cliente o empleado
        usuarioRepository.insertarUsuario(usuario.getLOGIN(), usuario.getPALABRACLAVE(), usuario.getROL(), usuario.getDOCUMENTOIDENTIFICACIONTIPO(), usuario.getDOCUMENTOIDENTIFICACIONNUMERO(), usuario.getNOMBRE(), usuario.getNACIONALIDAD(), usuario.getDIRECCIONFISICA(), usuario.getDIRECCIONELECTRONICA(), usuario.getTELEFONO(), usuario.getCIUDAD(), usuario.getDEPARTAMENTO(), usuario.getCODIGOPOSTAL());
        return "redirect:/usuarios";
    }

}
