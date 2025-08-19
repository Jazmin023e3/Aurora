package Esfe.Aurora.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnilloRepository extends JpaRepository<Esfe.Aurora.Modelos.Anillo, Long> {
}