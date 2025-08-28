package Esfe.Aurora.Controladores;

import Esfe.Aurora.Modelos.Cliente;
import Esfe.Aurora.Servicios.Interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes/index"; // Usamos 'index' para la vista principal
    }

    // Mostrar formulario para crear/editar
    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            Optional<Cliente> cliente = clienteService.findById(id);
            if (cliente.isPresent()) {
                model.addAttribute("cliente", cliente.get());
            } else {
                return "redirect:/clientes";
            }
        } else {
            model.addAttribute("cliente", new Cliente());
        }
        return "clientes/form";
    }

    // Guardar un cliente (nuevo o editado)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente, RedirectAttributes redirect) {
        clienteService.save(cliente);
        redirect.addFlashAttribute("msg", "Cliente guardado exitosamente.");
        return "redirect:/clientes";
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirect) {
        try {
            clienteService.deleteById(id);
            redirect.addFlashAttribute("msg", "Cliente eliminado correctamente.");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "No se pudo eliminar el cliente.");
        }
        return "redirect:/clientes";
    }
}
