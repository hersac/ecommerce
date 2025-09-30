package com.hersac.backend.common.auditoria;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hersac.backend.modules.users.usuarios.models.Usuario;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntidadAuditable {

	@CreatedDate
	private LocalDateTime fechaCreacion;

	@LastModifiedDate
	private LocalDateTime fechaModificacion;

	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_creacion", nullable = true, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuarioCreacion;

	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_modificacion", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuarioModificacion;

}
