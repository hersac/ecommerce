package com.hersac.backend.modules.comercial.carritocompras.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCarritoComprasDTO {

	private Long id;

	private String identificacion;

	private String estado;

	private Boolean estaActivo;

}
