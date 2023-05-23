package com.softtek.lambda1.repo;

import com.softtek.lambda1.modelo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo  extends JpaRepository<Orders,Short> {
}
