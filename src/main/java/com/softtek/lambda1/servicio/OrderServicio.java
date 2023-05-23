package com.softtek.lambda1.servicio;

import com.softtek.lambda1.modelo.Orders;
import com.softtek.lambda1.repo.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServicio implements IOrderServicio{
    @Autowired
    private IOrderRepo repo;
    @Override
    public List<Orders> obtenerTodos() {
        return repo.findAll();
    }
}
