package com.hersac.backend.modules.comercial.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClienteDTO {

	private Long id;

	private String primerNombre;

	private String segundoNombre;

	private String primerApellido;

	private String segundoApellido;

	private String tipoDocumento;

	private String identificacion;

}
