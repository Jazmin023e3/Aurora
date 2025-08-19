package Esfe.Aurora.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Esfe.Aurora.Modelos.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
