package Esfe.Aurora.Servicios.Implementacion;

import Esfe.Aurora.Modelos.Anillo;
import Esfe.Aurora.Repositorios.AnilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnilloService {

    @Autowired
    private AnilloRepository anilloRepository;

    // Obtener todos los anillos
    public List<Anillo> findAll() {
        return anilloRepository.findAll();
    }

    // Guardar o actualizar un anillo
    public Anillo save(Anillo anillo) {
        return anilloRepository.save(anillo);
    }

    // Buscar anillo por ID
    public Optional<Anillo> findById(Long id) {
        return anilloRepository.findById(id);
    }

    // Eliminar anillo por ID
    public void deleteById(Long id) {
        anilloRepository.deleteById(id);
    }
}
  