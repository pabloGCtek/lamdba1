package com.softtek.lambda.repo;

import com.softtek.lambda.modelo.Producto;

import java.util.List;

public interface IProductoRepo {
    public List<Producto> findAll();
}
