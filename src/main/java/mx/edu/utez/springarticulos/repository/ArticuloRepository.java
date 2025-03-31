package mx.edu.utez.springarticulos.repository;

import mx.edu.utez.springarticulos.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
