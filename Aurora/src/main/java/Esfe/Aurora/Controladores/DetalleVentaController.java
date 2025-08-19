package Esfe.Aurora.Controladores;

import Esfe.Aurora.Modelos.Venta;
import Esfe.Aurora.Servicios.Implementacion.ClienteService;
import Esfe.Aurora.Servicios.Implementacion.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class DetalleVentaController { // <-- Cambiado aquí

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ventas", ventaService.findAll());
        return "ventas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("clientes", clienteService.findAll());
        return "ventas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Venta venta) {
        ventaService.save(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("venta", ventaService.findById(id));
        model.addAttribute("clientes", clienteService.findAll());
        return "ventas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        ventaService.deleteById(id);
        return "redirect:/ventas";
    }
}
