package Esfe.Aurora.Controladores;

import Esfe.Aurora.Modelos.Anillo;
<<<<<<< HEAD
import Esfe.Aurora.Servicios.Implementacion.AnilloService;

=======
import Esfe.Aurora.Servicios.AnilloService;
>>>>>>> 874ec47 (se le cambio el anilloController y anilloService)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anillos")
public class AnilloController {

    @Autowired
    private AnilloService anilloService;

    // Listar todos los anillos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("anillos", anilloService.findAll());
        return "anillos/lista"; // Debes tener templates/anillos/lista.html
    }

    // Mostrar formulario nuevo
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("anillo", new Anillo());
        return "anillos/form"; // Debes tener templates/anillos/form.html
    }

    // Guardar un anillo
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Anillo anillo) {
        anilloService.save(anillo);
        return "redirect:/anillos";
    }

    // Editar un anillo existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Anillo anillo = anilloService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("anillo", anillo);
        return "anillos/form";
    }

    // Eliminar un anillo
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        anilloService.deleteById(id);
        return "redirect:/anillos";
    }
}
