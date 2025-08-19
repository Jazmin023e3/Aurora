package Esfe.Aurora.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Esfe.Aurora.Modelos.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}