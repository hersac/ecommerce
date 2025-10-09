package com.hersac.backend.modules.comercial.clientes.models;

import com.hersac.backend.common.auditoria.EntidadAuditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadAuditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;

	@Column(name = "primer_nombre", length = 50, nullable = false)
	private String primerNombre;

	@Column(name = "segundo_nombre", length = 50)
	private String segundoNombre;

	@Column(name = "primer_apellido", length = 50, nullable = false)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 50)
	private String segundoApellido;

	@Column(name = "tipo_documento", length = 2, nullable = false)
	private String tipoDocumento;

	@Column(name = "identificacion", length = 11, nullable = false, unique = true)
	private String identificacion;

}
