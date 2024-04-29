package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.parranderos.modelo.Cliente;
import uniandes.edu.co.parranderos.modelo.Empleado;
import uniandes.edu.co.parranderos.modelo.Usuario;
import uniandes.edu.co.parranderos.repositorio.ClienteRepository;
import uniandes.edu.co.parranderos.repositorio.EmpleadoRepository;
import uniandes.edu.co.parranderos.repositorio.UsuarioRepository;


//@RestController // Debo cambiarlo por @Controller cuando ya teng ala interfaz
@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarioCliente", new Cliente());
        model.addAttribute("usuarioEmpleado", new Empleado());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario, @ModelAttribute Cliente usuarioCliente, @ModelAttribute Empleado usuarioEmpleado) {
        usuarioRepository.insertarUsuario(usuario.getLOGIN(), usuario.getPALABRACLAVE(), usuario.getROL(), usuario.getDOCUMENTOIDENTIFICACIONTIPO(), usuario.getDOCUMENTOIDENTIFICACIONNUMERO(), usuario.getNOMBRE(), usuario.getNACIONALIDAD(), usuario.getDIRECCIONFISICA(), usuario.getDIRECCIONELECTRONICA(), usuario.getTELEFONO(), usuario.getCIUDAD(), usuario.getDEPARTAMENTO(), usuario.getCODIGOPOSTAL());
        System.out.println(usuarioCliente.getID() + " " + usuarioCliente.getTIPOCLIENTE());
        if(usuario.getROL().equals("Cliente")){clienteRepository.insertarCliente(usuario.getDOCUMENTOIDENTIFICACIONNUMERO(), usuarioCliente.getTIPOCLIENTE());}
        else{empleadoRepository.insertarEmpleado(usuario.getROL(), usuarioEmpleado.getIDEMPLEADO(), usuario.getDOCUMENTOIDENTIFICACIONNUMERO(), usuario.getDIRECCIONFISICA());};
        return "redirect:/usuarios/new";
    }

}
