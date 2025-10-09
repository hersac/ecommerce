package com.hersac.backend.modules.comercial.clientes.dto;

import com.hersac.backend.common.validation.OnCreate;
import com.hersac.backend.common.validation.OnUpdate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearClienteDTO {

	@NotNull(message = "El primer nombre no puede ser nulo", groups = { OnCreate.class })
	@NotBlank(message = "El primer nombre no puede estar vacío", groups = { OnCreate.class })
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "El primer nombre solo debe contener letras",
			groups = { OnCreate.class, OnUpdate.class })
	@Size(min = 2, max = 50, message = "El primer nombre debe tener entre 2 y 50 caracteres",
			groups = { OnCreate.class, OnUpdate.class })
	private String primerNombre;

	@Pattern(regexp = "^[a-zA-Z ]+$", message = "El segundo nombre solo debe contener letras",
			groups = { OnCreate.class, OnUpdate.class })
	@Size(max = 50, message = "El segundo nombre debe tener como máximo 50 caracteres",
			groups = { OnCreate.class, OnUpdate.class })
	private String segundoNombre;

	@NotNull(message = "El primer apellido no puede ser nulo", groups = { OnCreate.class })
	@NotBlank(message = "El primer apellido no puede estar vacío", groups = { OnCreate.class })
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "El primer apellido solo debe contener letras",
			groups = { OnCreate.class, OnUpdate.class })
	@Size(min = 2, max = 50, message = "El primer apellido debe tener entre 2 y 50 caracteres",
			groups = { OnCreate.class, OnUpdate.class })
	private String primerApellido;

	@Pattern(regexp = "^[a-zA-Z ]+$", message = "El segundo apellido solo debe contener letras",
			groups = { OnCreate.class, OnUpdate.class })
	@Size(max = 50, message = "El segundo apellido debe tener como máximo 50 caracteres",
			groups = { OnCreate.class, OnUpdate.class })
	private String segundoApellido;

	@NotNull(message = "El tipo de documento no puede ser nulo", groups = { OnCreate.class })
	@NotBlank(message = "El tipo de documento no puede estar vacío", groups = { OnCreate.class })
	@Size(min = 2, max = 2, message = "El tipo de documento debe tener exactamente 2 caracteres",
			groups = { OnCreate.class, OnUpdate.class })
	@Pattern(regexp = "^[a-zA-Z]+$", message = "El tipo de documento solo debe contener letras",
			groups = { OnCreate.class, OnUpdate.class })
	private String tipoDocumento;

	@NotNull(message = "La identificación no puede ser nula", groups = { OnCreate.class })
	@NotBlank(message = "La identificación no puede estar vacía", groups = { OnCreate.class })
	@Pattern(regexp = "^[0-9]+$", message = "La identificación solo debe contener números",
			groups = { OnCreate.class, OnUpdate.class })
	@Size(min = 7, max = 11, message = "La identificación debe tener entre 7 y 11 dígitos",
			groups = { OnCreate.class, OnUpdate.class })
	private String identificacion;

}
