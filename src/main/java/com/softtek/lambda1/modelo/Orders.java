package com.softtek.lambda.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Orders {
    @Id
    @Column(name="porder_id") private Short id;
    @Column(name="customer_id") private Short idCliente;
    @Column(name="order_date") private Date fechaOrden;
    @Column(name="required_date") private Date fechaReq;
    @Column(name="shipped_date") private Date fechaEnvio;;
    @Column(name="ship_via") private Short envioPor;
    @Column(name="freight") private Short freight;
    @Column(name="ship_name") private String nombreBarco;
    @Column(name="ship_address") private String direccionEnvio;
    @Column(name="ship_city") private String cioudadEnvio;
    @Column(name="ship_region") private String regionEnvio;
    @Column(name="ship_postal_code") private Short codigoPostal;
    @Column(name="ship_country") private String paisEnvio;

}
