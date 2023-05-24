package com.softtek.lambda1;

import com.softtek.lambda1.modelo.Clientes;
import com.softtek.lambda1.modelo.Orders;
import com.softtek.lambda1.modelo.Producto;
import com.softtek.lambda1.servicio.IClienteServicio;
import com.softtek.lambda1.servicio.IOrderServicio;
import com.softtek.lambda1.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;

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
        List<Clientes> listaC = servicioC.obtenerTodos();
        List<Producto> listaPr = servicio.obtenerTodos();
        List<Orders> listaO = servicioO.obtenerTodos();


        //-- Sentencia Select
        //--Obtener todos los registros y todos los campos de la tabla de productos
        System.out.println(listaPr);

        //--Obtener una consulta con Productid, productname, supplierid, categoryId, UnistsinStock, UnitPrice
            listaPr.stream()
                    .map(p -> p.getId() + p.getNombre() +", "+ p.getProveedor() +", "+ p.getCategoriaId() +", "+ p.getUnidadesEsistencia() +", "+ p.getPrecioUnitario())
                    .forEach(System.out::println);
        System.out.println("===============================");

        //--Crear una consulta para obtener el IdOrden, IdCustomer, Fecha de la orden de la tabla de ordenes.
        listaO.stream()
                .map(o -> o.getId() +", "+ o.getIdCliente() +", "+ o.getFechaOrden() )
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Crear una consulta para obtener el OrderId, EmployeeId, Fecha de la orden.
        listaO.stream()
                .map(o -> o.getId() +", "+ o.getIdEmpleado() +", "+ o.getFechaOrden() )
                .forEach(System.out::println);
        System.out.println("===============================");


        //--Columnas calculadas

        //--Obtener una consulta con Productid, productname y valor del inventario, valor inventrio (UnitsinStock * UnitPrice)
        listaPr.stream()
                .map(p -> p.getId() +", "+ p.getNombre() +", "+ (p.getUnidadesEsistencia() * p.getPrecioUnitario()) )
                .forEach(System.out::println);
        System.out.println("===============================");

        //-- Cuanto vale el punto de reorden

        listaPr.stream()
                .filter(p -> p.getNivelReordenar() != null)
                .map(p ->(p.getNivelReordenar() * p.getPrecioUnitario()) )
                .forEach(System.out::println);
        System.out.println("===============================");

        //-- Mostrar una consulta con Productid, productname y precio, el nombre del producto debe estar en mayuscula
        listaPr.stream()
                .map(p ->p.getId() +", "+ p.getNombre().toUpperCase()+", "+ p.getPrecioUnitario()  )
                .forEach(System.out::println);
        System.out.println("===============================");

        //-- Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres */

        listaPr.stream()
                .map(p ->p.getId() +", "+ p.getNombre().substring(0, Math.min(p.getNombre().length(), 10))+", "+ p.getPrecioUnitario()  )
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtenre una consulta que muestre la longitud del nombre del producto
        listaPr.stream()
                .map(p ->p.getId() +", "+ p.getNombre().length())
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener una consulta de la tabla de productos que muestre el nombre en minúscula
        listaPr.stream()
                .map(p ->p.getId() +", "+ p.getNombre().toLowerCase())
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Mostrar una consulta con Productid, productname y precio, el nombre del producto debe contener unicamente 10 caracteres y se deben mostrar en mayúscula */
        listaPr.stream()
                .map(p ->p.getId() +", "+ p.getNombre().toUpperCase().substring(0,Math.min(p.getNombre().length(), 10)) +", "+ p.getPrecioUnitario() +", ")
                .forEach(System.out::println);
        System.out.println("===============================");

        // --Filtros


        //--Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais Obtener los clientes cuyo pais sea Spain
        listaC.stream()
                .filter(p -> p.getPais().equals("Spain"))
                .map(p ->p.getId() +", "+ p.getCompaniaContacto() +", "+ p.getPais() +", ")
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U
        listaC.stream()
                .filter(p -> p.getPais().substring(0,1).equals("U"))
                .map(p ->p.getId() +", "+ p.getCompaniaContacto() +", "+ p.getPais() +", ")
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener de la tabla de Customers las columnas CustomerId, CompanyName, Pais, Obtener los clientes cuyo pais comience con la letra U,S,A
        listaC.stream()
                .filter(p -> p.getPais().substring(0,1).equals("U")||p.getPais().substring(0,1).equals("S")||p.getPais().substring(0,1).equals("A"))
                .map(p ->p.getId() +", "+ p.getCompaniaContacto() +", "+ p.getPais() +", ")
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice cuyos precios esten entre 50 y 150
        listaPr.stream()
                .filter(p -> p.getPrecioUnitario() >50 && p.getPrecioUnitario() <150 )
                .map(p ->p.getId() +", "+ p.getNombre() +", "+ p.getPrecioUnitario() +", ")
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener de la tabla de Productos las columnas productid, ProductName, UnitPrice, UnitsInStock cuyas existencias esten entre 50 y 100
        listaPr.stream()
                .filter(p -> p.getUnidadesEsistencia() >50 && p.getUnidadesEsistencia() <150 )
                .map(p ->p.getId() +", "+ p.getNombre() +", "+ p.getPrecioUnitario() +", " + p.getUnidadesEsistencia())
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener las columnas OrderId, CustomerId, employeeid de la tabla de ordenes cuyos empleados sean 1, 4, 9
        listaO.stream()
                .filter(p -> p.getIdEmpleado() == 1 ||p.getIdEmpleado() == 4 || p.getIdEmpleado() == 9)
                .map(p ->p.getId() +", "+ p.getIdCliente() +", "+ p.getIdEmpleado() +", ")
                .forEach(System.out::println);
        System.out.println("===============================");

        //-- ORDENAR EL RESULTADO DE LA QUERY POR ALGUNA COLUMNA Obtener la información de la tabla de Products, Ordenarlos por Nombre del Producto de forma ascendente
        listaPr.stream()
                .sorted(Comparator.comparing(Producto::getNombre))
                .forEach(System.out::println);
        System.out.println("===============================");

        //      -- Obtener la información de la tabla de Products, Ordenarlos por Categoria de forma ascendente y por precio unitario de forma descendente
        listaPr.stream()
                .sorted(Comparator.comparing(Producto::getCategoriaId) )
                .sorted(Comparator.comparing(Producto::getPrecioUnitario).reversed())
                .forEach(System.out::println);
        System.out.println("===============================");

        //-- Obtener la información de la tabla de Clientes, Customerid, CompanyName, city, country ordenar por pais, ciudad de forma ascendente
        listaC.stream()
                .sorted(Comparator.comparing(Clientes::getPais))
                .sorted(Comparator.comparing(Clientes::getCiudad))
                .map(p ->p.getId() +", "+ p.getCompaniaContacto() +", "+ p.getCiudad() +", " + p.getPais())
                .forEach(System.out::println);
        System.out.println("===============================");

        //      -- Obtener los productos productid, productname, categoryid, supplierid ordenar por categoryid y supplier únicamente mostrar aquellos cuyo precio esté entre 25 y 200
        listaPr.stream()
                .filter(p -> p.getPrecioUnitario() >25 && p.getPrecioUnitario() < 200)
                .sorted(Comparator.comparing(Producto::getCategoriaId) )
                .sorted(Comparator.comparing(Producto::getPrecioUnitario).reversed())
                .map(p ->p.getId() +", "+ p.getNombre() +", "+ p.getCategoriaId() +", " + p.getProveedor())
                .forEach(System.out::println);
        System.out.println("===============================");



        //--Funciones agregación

        //--Cuantos productos hay en la tabla de productos
        System.out.println(
                listaPr.stream()
                .count());
        System.out.println("===============================");

        //--de la tabla de productos Sumar las cantidades en existencia
        System.out.println(
                listaPr.stream()
                        .mapToInt(p -> p.getUnidadesEsistencia())
                        .sum());
        System.out.println("===============================");

        //--Promedio de los precios de la tabla de productos
        System.out.println(
                listaPr.stream()
                        .mapToDouble(p -> p.getPrecioUnitario())
                        .average());
        System.out.println("===============================");

        //--Ordenar

        //--Obtener los datos de productos ordenados descendentemente por precio unitario de la categoría 1
        listaPr.stream()
                .filter(p -> p.getCategoriaId() == 1)
                .sorted(Comparator.comparing(Producto::getPrecioUnitario) )
                .forEach(System.out::println);
        System.out.println("===============================");

        // --Obtener los datos de los clientes(Customers) ordenados descendentemente por nombre(CompanyName) que se encuentren en la ciudad(city) de barcelona, Lisboa
        listaC.stream()
                .filter(p -> p.getCiudad().equals("Barcelona") || p.getCiudad().equals("Lisboa"))
                .sorted(Comparator.comparing(Clientes::getCompaniaContacto) )
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener los datos de las ordenes, ordenados descendentemente por la fecha de la orden cuyo cliente(CustomerId) sea ALFKI
        listaO.stream()
                .filter(p -> p.getIdCliente().equals("ALEKI"))
                .sorted(Comparator.comparing(Orders::getFechaOrden))
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener los datos del detalle de ordenes, ordenados ascendentemente por precio cuyo producto sea 1, 5 o 20

        System.out.println("===============================");

        //--Obtener los datos de las ordenes ordenados ascendentemente por la fecha de la orden cuyo empleado sea 2 o 4
        listaO.stream()
                .filter(p -> p.getIdEmpleado() ==2 || p.getIdEmpleado() ==4)
                .sorted(Comparator.comparing(Orders::getFechaOrden).reversed() )
                .forEach(System.out::println);
        System.out.println("===============================");

        //--Obtener los productos cuyo precio están entre 30 y 60 ordenado por nombre

        System.out.println("===============================");


    }

}
