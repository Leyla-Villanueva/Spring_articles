package mx.edu.utez.springarticulos.controller;

import mx.edu.utez.springarticulos.entity.Articulo;
import mx.edu.utez.springarticulos.servicio.ArticuloServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
    private final ArticuloServicio articuloServicio;

    public ArticuloController(ArticuloServicio articuloServicio) {
        this.articuloServicio = articuloServicio;
    }

        //consulta general
    @GetMapping()
    public List<Articulo> listarArticulos() {
        return articuloServicio.obtenerArticulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        return articuloServicio.obtenerArticulo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity save(@RequestBody Articulo articulo) {
        return ResponseEntity.ok(articuloServicio.guardar(articulo));
    }

    @PutMapping
    public ResponseEntity update(
            @PathVariable Long id, @RequestBody Articulo articulo){
        return articuloServicio.obtenerArticulo(id)
                .map(articuloObj -> {
                    articuloObj.setNombre(articulo.getNombre());
                    articuloObj.setPrecio(articulo.getPrecio());
                    articuloObj.setNumeroInventario(articulo.getNumeroInventario());
                    articuloObj.setColor(articulo.getColor());
                    return ResponseEntity.ok(articuloServicio.guardar(articuloObj));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Articulo> eliminar(@PathVariable long id) {
        return articuloServicio.obtenerArticulo(id)
                .map(articulo -> {
                    articuloServicio.eliminar(id);
                    return ResponseEntity.ok(articulo);
                }).orElse(ResponseEntity.notFound().build());
    }

    public String metodoMalo(){
        System.out.println("Esto es un mexican Logger");
        int x = 0;
        int y = 0;

        // int multimplicación = y*x;
        return "Hola"+y;
    }




}
