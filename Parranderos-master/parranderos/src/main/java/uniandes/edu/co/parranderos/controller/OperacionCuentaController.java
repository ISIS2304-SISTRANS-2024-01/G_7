package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.transaction.Transactional;
import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.modelo.OperacionCuenta;
import uniandes.edu.co.parranderos.repositorio.CuentaRepository;
import uniandes.edu.co.parranderos.repositorio.OperacionCuentaRepository;

@Controller
public class OperacionCuentaController 
{

    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/operacionCuenta/nueva")
    public String operacionCuentaForma(Model model)
    {
        model.addAttribute("OperacionCuenta", new OperacionCuenta());
        return "OperacionCuenta nueva";
    }

    @PostMapping("/retirar")
    @Transactional
    public String retirarDinero(@RequestParam("monto") Integer monto, @RequestParam("cuentaOrigen") Integer cuentaOrigen, RedirectAttributes redirectAttributes) 
    {
        try 
        {
            operacionCuentaRepository.restarSaldoOrigen(monto, cuentaOrigen);
            redirectAttributes.addFlashAttribute("mensaje", "Retiro realizado exitosamente");
        } 
        catch (Exception e) 
        {
            redirectAttributes.addFlashAttribute("mensaje", "Error al realizar el retiro: " + e.getMessage());
            return "redirect:/operacionCuenta/nueva";
        }

        return "redirect:/operacionCuenta/nueva";
    }

    @PostMapping("/consignar")
    @Transactional
    public String consignarDinero(@RequestParam("monto") Integer monto, @RequestParam("cuentaDestino") Integer cuentaDestino, RedirectAttributes redirectAttributes) 
    {
        try 
        {
            operacionCuentaRepository.consignarOperacionCuenta(monto, "Consignacion", cuentaDestino, cuentaDestino);
            operacionCuentaRepository.sumarSaldoDestino(monto, cuentaDestino);
            redirectAttributes.addFlashAttribute("mensaje", "Consignación realizada exitosamente");
        } 
        catch (Exception e) 
        {
            redirectAttributes.addFlashAttribute("mensaje", "Error al realizar la consignación: " + e.getMessage());
            return "redirect:/operacionCuenta/nueva";
        }

        return "redirect:/operacionCuenta/nueva";
    }

    @PostMapping("/transferir")
    @Transactional
    public String transferirDinero(@RequestParam("monto") Integer monto, @RequestParam("cuentaOrigen") Integer cuentaOrigen, @RequestParam("cuentaDestino") Integer cuentaDestino, RedirectAttributes redirectAttributes) {
        try 
        {
            operacionCuentaRepository.restarSaldoOrigen(monto, cuentaOrigen);
            operacionCuentaRepository.sumarSaldoDestino(monto, cuentaDestino);
            redirectAttributes.addFlashAttribute("mensaje", "Transferencia realizada exitosamente");
        } 
        catch (Exception e) 
        {
            redirectAttributes.addFlashAttribute("mensaje", "Error al realizar la transferencia: " + e.getMessage());
            return "redirect:/operacionCuenta/nueva";
        }

        return "redirect:/operacionCuenta/nueva";

        // revisar redirecciones
    }


}