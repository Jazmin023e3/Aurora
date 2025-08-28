package Esfe.Aurora.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Esfe.Aurora.Modelos.Anillo;

@Repository
public interface AnilloRepository extends JpaRepository<Anillo, Integer> {
}