package com.duoc.msgestion.repository;

import com.duoc.msgestion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}