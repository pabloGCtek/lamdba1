package com.softtek.lambda1.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Clientes {
    @Id
    @Column(name="customer_id") private String id;
    @Column(name="company_name") private String companiaContacto;
    @Column(name="contact_name") private String nombreContacto;
    @Column(name="contact_title") private String titContacto;
    @Column(name="address") private String direccion;
    @Column(name="city") private String ciudad;
    @Column(name="region") private String region;
    @Column(name="postal_code") private String codigoPostal;
    @Column(name="country") private String pais;
    @Column(name="phone") private String telefono;
    @Column(name="fax") private String fax;
}
