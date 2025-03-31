package mx.edu.utez.springarticulos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private String numeroInventario;
    private String color;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nnombre) {
        this.nombre = nnombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
