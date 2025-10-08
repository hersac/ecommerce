package com.hersac.backend.modules.comercial.carritocompras.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hersac.backend.common.auditoria.EntidadAuditable;
import com.hersac.backend.modules.users.usuarios.models.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carritos_compras")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarritoCompras extends EntidadAuditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carritoId;

	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "esta_activo")
	private Boolean estaActivo = true;

	@Column(name = "estado")
	private String estado;

	// Relaciones
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuarioId;

}
