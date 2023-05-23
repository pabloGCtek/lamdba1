package com.softtek.lambda1.servicio;

import com.softtek.lambda1.modelo.Producto;
import com.softtek.lambda1.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private IProductoRepo repo;
    @Override
    public List<Producto> obtenerTodos() {
        return repo.findAll();
    }
}
