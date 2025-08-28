
package Esfe.Aurora.Controladores;

import Esfe.Aurora.Modelos.Anillo;
import Esfe.Aurora.Servicios.Interfaces.IAnilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/anillos")
public class AnilloController {

    @Autowired
    private IAnilloService anilloService;

    // LISTAR ANILLOS CON PAGINACIÓN
    @GetMapping
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Anillo> anillos = anilloService.buscarTodos(pageable);
        model.addAttribute("anillos", anillos);

        int totalPages = anillos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "anillo/index"; // Retorna a la vista 'index.html' en la carpeta 'anillo'
    }

    // FORMULARIO PARA CREAR UN NUEVO ANILLO
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("anillo", new Anillo());
        model.addAttribute("action", "create");
        return "anillo/mant"; // Retorna a la vista 'mant.html' para crear
    }

    // FORMULARIO PARA EDITAR UN ANILLO EXISTENTE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes redirect) {
        Optional<Anillo> anillo = anilloService.buscarPorId(id);
        if (anillo.isPresent()) {
            model.addAttribute("anillo", anillo.get());
            model.addAttribute("action", "edit");
            return "anillo/mant"; // Retorna a la vista 'mant.html' para editar
        } else {
            redirect.addFlashAttribute("msgError", "Anillo no encontrado.");
            return "redirect:/anillos";
        }
    }

    // FORMULARIO PARA VER UN ANILLO (solo lectura)
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model, RedirectAttributes redirect) {
        Optional<Anillo> anillo = anilloService.buscarPorId(id);
        if (anillo.isPresent()) {
            model.addAttribute("anillo", anillo.get());
            model.addAttribute("action", "view");
            return "anillo/mant"; // Retorna a la vista 'mant.html' para ver
        } else {
            redirect.addFlashAttribute("msgError", "Anillo no encontrado.");
            return "redirect:/anillos";
        }
    }

    // FORMULARIO PARA CONFIRMAR ELIMINACIÓN
    @GetMapping("/delete/{id}")
    public String deleteConfirm(@PathVariable Integer id, Model model, RedirectAttributes redirect) {
        Optional<Anillo> anillo = anilloService.buscarPorId(id);
        if (anillo.isPresent()) {
            model.addAttribute("anillo", anillo.get());
            model.addAttribute("action", "delete");
            return "anillo/mant"; // Retorna a la vista 'mant.html' para confirmar eliminación
        } else {
            redirect.addFlashAttribute("msgError", "Anillo no encontrado.");
            return "redirect:/anillos";
        }
    }

    // PROCESA LA PETICIÓN POST PARA CREAR O ACTUALIZAR
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Anillo anillo, BindingResult result,
                       @RequestParam String action, RedirectAttributes redirect, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("action", action);
            return "anillo/mant";
        }
        
        try {
            anilloService.crearOeditar(anillo);
            redirect.addFlashAttribute("msgSuccess", "Anillo guardado correctamente.");
        } catch (Exception e) {
            redirect.addFlashAttribute("msgError", "Error al guardar el anillo: " + e.getMessage());
        }

        return "redirect:/anillos";
    }

    // PROCESA LA PETICIÓN POST PARA ELIMINAR
    @PostMapping("/delete")
    public String deleteAnillo(@ModelAttribute Anillo anillo, RedirectAttributes redirect) {
        try {
            anilloService.eliminarPorId(anillo.getIdAnillo());
            redirect.addFlashAttribute("msgSuccess", "Anillo eliminado correctamente.");
        } catch (Exception e) {
            redirect.addFlashAttribute("msgError", "Error al eliminar el anillo: " + e.getMessage());
        }
        return "redirect:/anillos";
    }
}