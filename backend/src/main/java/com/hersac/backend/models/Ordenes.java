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
public class Ordenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordenId;

	private Long userId;

	private Date FechaOrden;

	private String direccionEnvio;

	private Boolean estadoOrden;

}
