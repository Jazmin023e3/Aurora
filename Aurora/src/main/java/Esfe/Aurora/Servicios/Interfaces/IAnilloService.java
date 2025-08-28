package Esfe.Aurora.Servicios.Interfaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import Esfe.Aurora.Modelos.Anillo;


public interface IAnilloService {

    Page<Anillo> buscarTodos(Pageable pageable);

    List<Anillo> obtenerTodos();

    Optional<Anillo> buscarPorId(Integer id);

    Anillo crearOeditar(Anillo anillo);

    void eliminarPorId(Integer id);

}
