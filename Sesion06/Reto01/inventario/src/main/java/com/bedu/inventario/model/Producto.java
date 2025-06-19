package com.bedu.inventario.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @Min(value = 1, message = "El precio debe ser mayor o igual a 1")
    private double precio;

    // Justo después de los demás atributos
    @ManyToOne
    @JoinColumn(name = "categoria_id") // nombre de la columna FK en la tabla productos
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;



    protected Producto() {} // Constructor por defecto requerido por JPA

    // Constructor público para crear objetos de tipo Producto con los campos necesarios
// Dentro del constructor público (debajo de los otros parámetros)
public Producto(String nombre, String descripcion, double precio, Categoria categoria, Marca marca  ) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.categoria = categoria;
    this.marca = marca; 
}

    // Getters para acceder a los atributos (necesarios para el funcionamiento de JPA y buenas prácticas)
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    // Agregar un getter al final de los métodos de acceso
    public Categoria getCategoria() {return categoria;}
    public Marca getMarca() { return marca; }

    // Método que permite imprimir el objeto de forma legible (útil para logs o consola)
// Dentro del método toString(), agrega la categoría de forma opcional
@Override
public String toString() {
    return "Producto{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", descripcion='" + descripcion + '\'' +
            ", precio=" + precio +
            ", categoria=" + (categoria != null ? categoria.getNombre() : "N/A") +
            ", marca=" + (marca != null ? marca.getNombre() : "N/A") +
            '}';
}
}