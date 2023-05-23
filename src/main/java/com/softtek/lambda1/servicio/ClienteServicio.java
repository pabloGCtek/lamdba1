package com.softtek.lambda1.servicio;

import com.softtek.lambda1.modelo.Clientes;
import com.softtek.lambda1.modelo.Producto;
import com.softtek.lambda1.repo.IClienteRepo;
import com.softtek.lambda1.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClienteServicio implements IClienteServicio{
    @Autowired
    private IClienteRepo repo;
    @Override
    public List<Clientes> obtenerTodos() {
        return repo.findAll();
    }
}
