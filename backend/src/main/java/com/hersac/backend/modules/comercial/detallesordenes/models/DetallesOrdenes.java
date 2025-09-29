package com.hersac.backend.modules.comercial.detallesordenes.models;

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
public class DetallesOrdenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detallesOCId;

	private Long ordenId;

	private Long prodId;

	private Integer cantidad;

}
