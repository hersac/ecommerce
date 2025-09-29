package com.hersac.backend.modules.comercial.detallescarritoscompras.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles_cc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detalleId;

	private String identificacion;

	private Long prodId;

	private Integer cantidad;

	private Double precioUnitario;

	private Double subtotal;

}
