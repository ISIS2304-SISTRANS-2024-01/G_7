package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    
    @PostMapping("/operacionCuenta/retirar")
    public String retirarDinero(@RequestParam Integer id, @RequestParam Integer monto, RedirectAttributes redirectAttributes) 
    {
        OperacionCuenta operacionCuenta = operacionCuentaRepository.darOperacionPrestamo(id);

        try 
        {
            Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La cuenta con el número especificado no existe"));

            if (cuenta.getSALDO() >= monto) 
            {
                cuenta.setSALDO(cuenta.setSALDO() - monto);
                cuentaRepository.save(cuenta);

                operacionCuentaRepository.insertarOperacionCuenta(id, operacionCuenta.getTIPOPAGO(), operacionCuenta.getNUMEROCUENTAAFECTADA(), operacionCuenta.getNUMEROCUENTA());

                redirectAttributes.addFlashAttribute("successMessage", "Retiro exitoso");
            } 
            else 
            {
                redirectAttributes.addFlashAttribute("errorMessage", "Saldo insuficiente para realizar el retiro");
            }
        } 
        catch (Exception e) 
        {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al procesar el retiro: " + e.getMessage());
        }
        return "redirect:/operacionCuenta/nueva";
    }


    // @PostMapping("/operacionCuenta/consignar")
    // public String consignarDinero(@RequestParam Integer id, @RequestParam Double monto, RedirectAttributes redirectAttributes) 
    // {
    //     OperacionCuenta operacionCuenta = operacionCuentaRepository.darOperacionPrestamo(id);

    //     try 
    //     {
    //         Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("La cuenta con el número especificado no existe"));

    //         cuenta.setSaldo(cuenta.setSALDO() + monto);
    //         cuentaRepository.save(cuenta);

    //     // Registrar la operación de consignación en el log
    //         operacionCuentaRepository.insertarOperacionCuenta(/* Parámetros necesarios */);

    //         redirectAttributes.addFlashAttribute("successMessage", "Consignación exitosa");
    // } 
    // catch (Exception e) 
    // {
    //     redirectAttributes.addFlashAttribute("errorMessage", "Error al procesar la consignación: " + e.getMessage());
    // }

    // return "redirect:/operacionCuenta/nueva";
}

}
