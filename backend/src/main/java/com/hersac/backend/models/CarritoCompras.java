package com.hersac.backend.models;

import java.util.Date;

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
public class CarritoCompras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carritoId;

	private Long userId;

	private String identificacion;

	private Date fecha;

	private Boolean estadoCarrito;

}
