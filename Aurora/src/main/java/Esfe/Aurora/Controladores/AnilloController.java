package Esfe.Aurora.Controladores;

import Esfe.Aurora.Modelos.Anillo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anillos")
public class AnilloController {

    @Autowired
    private AnilloService anilloService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("anillos", anilloService.findAll());
        return "anillos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("anillo", new Anillo());
        return "anillos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Anillo anillo) {
        anilloService.save(anillo);
        return "redirect:/anillos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("anillo", anilloService.findById(id));
        return "anillos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        anilloService.deleteById(id);
        return "redirect:/anillos";
    }
}
