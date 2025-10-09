package com.hersac.backend.modules.comercial.carritocompras.dto;

import com.hersac.backend.common.validation.OnCreate;
import com.hersac.backend.common.validation.OnUpdate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearCarritoComprasDTO {

	@Pattern(regexp = "^[0-9]+$", message = "El campo 'identificacion' solo debe contener números.",
			groups = { OnCreate.class, OnUpdate.class })
	@Size(min = 6, max = 10, message = "El campo 'identificacion' debe tener entre 6 y 10 caracteres.",
			groups = { OnCreate.class, OnUpdate.class })
	@NotEmpty(message = "El campo 'identificacion' no puede estar vacío.", groups = OnCreate.class)
	@NotBlank(message = "El campo 'identificacion' es obligatorio.", groups = OnCreate.class)
	@NotNull(message = "El campo 'identificacion' no puede ser nulo.", groups = OnCreate.class)
	private String identificacion;

	@NotEmpty(message = "El campo 'estado' no puede estar vacío.", groups = OnCreate.class)
	@NotBlank(message = "El campo 'estado' es obligatorio.", groups = OnCreate.class)
	@NotNull(message = "El campo 'estado' no puede ser nulo.", groups = OnCreate.class)
	private String estado;

	private Boolean estaActivo;

}
