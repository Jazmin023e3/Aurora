package Esfe.Aurora.Servicios;

import Esfe.Aurora.Modelos.Venta;
import Esfe.Aurora.Repositorios.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    public void save(Venta venta) {
        ventaRepository.save(venta);
    }

    public Optional<Venta> findById(Long id) {
        return ventaRepository.findById(id);
    }

    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }
}
