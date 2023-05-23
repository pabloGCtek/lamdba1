package com.softtek.lambda1;

import com.softtek.lambda1.servicio.IClienteServicio;
import com.softtek.lambda1.servicio.IOrderServicio;
import com.softtek.lambda1.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lambda1Application implements CommandLineRunner {
    @Autowired
    private IProductoServicio servicio;
    @Autowired
    private IClienteServicio servicioC;
    @Autowired
    private IOrderServicio servicioO;
    public static void main(String[] args) {
        SpringApplication.run(Lambda1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(servicio.obtenerTodos());
        System.out.println(servicioC.obtenerTodos());
        System.out.println(servicioO.obtenerTodos());
    }
}
