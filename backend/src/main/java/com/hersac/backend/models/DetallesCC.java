package com.hersac.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallesCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleId;
    private String identificacion;
    private Long prodId;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
