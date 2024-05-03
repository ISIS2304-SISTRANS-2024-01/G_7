package uniandes.edu.co.parranderos.controller;

import java.util.Collection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.repositorio.CuentaRepository;


//@RestController // Debo cambiarlo por @Controller cuando ya teng ala interfaz
@Controller
public class CuentaController {
    
    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model, String TIPO, Integer SALDOINICIAL, Integer SALDOFINAL, Integer DOCUMENTOIDENTIFICACIONNUMERO) {
        if (TIPO == null || SALDOINICIAL == null || SALDOFINAL == null || DOCUMENTOIDENTIFICACIONNUMERO == null) {
            model.addAttribute("cuentas", cuentaRepository.darCuentas());   
        }else{
            model.addAttribute("cuentas", cuentaRepository.darCuentaRFC1(TIPO, SALDOINICIAL, SALDOFINAL, DOCUMENTOIDENTIFICACIONNUMERO));
        }
        return "cuentas";
    }

    @GetMapping("/cuenta/new")
    public String cuentaForm(Model model)
    {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNueva";
    }


    // @PostMapping("/cuenta/new/save")
    // public String cuentaGuardar(@ModelAttribute Cuenta cuenta)
    // {
    //     cuentaRepository.insertarCuenta(cuenta.getNUMEROCUENTA(), cuenta.getTIPO(), cuenta.getSALDO(), cuenta.getFECHAULTIMATRANSACCION(), cuenta.getESTADO(), cuenta.getDOCUMENTOIDENTIFICACIONNUMERO());
    //     return "redirect:/cuenta/new";
    // }

    @PostMapping("/cuenta/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) 
    {
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");
        // String fechaTransaccion = formatter.format(cuenta.getFECHAULTIMATRANSACCION());
        cuentaRepository.insertarCuenta(cuenta.getNUMEROCUENTA(), cuenta.getTIPO(), cuenta.getSALDO(), cuenta.getESTADO(), cuenta.getDOCUMENTOIDENTIFICACIONNUMERO());
        return "redirect:/cuenta/new";
    }

}