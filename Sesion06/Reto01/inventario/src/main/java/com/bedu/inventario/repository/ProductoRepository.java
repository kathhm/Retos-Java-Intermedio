package com.bedu.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bedu.inventario.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByPrecioGreaterThan(double precio);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByPrecioBetween(double min, double max);

    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}
