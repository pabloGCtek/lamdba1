package com.softtek.lambda1.repo;

import com.softtek.lambda1.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepo extends JpaRepository<Producto,Short> {
}
