package Esfe.Aurora.Controladores;

import Esfe.Aurora.Modelos.DetalleVenta;
import Esfe.Aurora.Servicios.DetalleVentaService;
import Esfe.Aurora.Servicios.VentaService;
import Esfe.Aurora.Servicios.AnilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles")
public class VentaController {

    @Autowired
    private DetalleVentaService detalleService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private AnilloService anilloService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detalles", detalleService.findAll());
        return "detalles/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("detalle", new DetalleVenta());
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("anillos", anilloService.findAll());
        return "detalles/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetalleVenta detalle) {
        detalleService.save(detalle);
        return "redirect:/detalles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("detalle", detalleService.findById(id));
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("anillos", anilloService.findAll());
        return "detalles/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        detalleService.deleteById(id);
        return "redirect:/detalles";
    }
}

