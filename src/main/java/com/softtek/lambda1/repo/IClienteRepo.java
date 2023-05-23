package com.softtek.lambda1.repo;

import com.softtek.lambda1.modelo.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepo extends JpaRepository<Clientes,String> {
}
