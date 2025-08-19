package Esfe.Aurora.Servicios;

import Esfe.Aurora.Modelos.DetalleVenta;
import Esfe.Aurora.Repositorios.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    public void save(DetalleVenta detalleVenta) {
        detalleVentaRepository.save(detalleVenta);
    }

    public Optional<DetalleVenta> findById(Long id) {
        return detalleVentaRepository.findById(id);
    }

    public void deleteById(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
