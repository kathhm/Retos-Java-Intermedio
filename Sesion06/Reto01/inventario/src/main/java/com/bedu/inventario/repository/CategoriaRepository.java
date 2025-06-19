package com.bedu.inventario.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bedu.inventario.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
}
