package mx.edu.utez.springarticulos.servicio;

import mx.edu.utez.springarticulos.entity.Articulo;
import mx.edu.utez.springarticulos.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServicio {
    private final ArticuloRepository articuloRepository;
    public ArticuloServicio(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    //consulta especifica
    public Optional<Articulo> obtenerArticulo(long id) {
        return articuloRepository.findById(id);
    }

    //consulta general
    public List<Articulo> obtenerArticulos() {
        return articuloRepository.findAll();
    }

    //crear
     public Articulo guardar(Articulo articulo) {
        return articuloRepository.save(articulo);
     }

     //eliminar
    public void eliminar(Long id) {
        articuloRepository.deleteById(id);
    }

}
