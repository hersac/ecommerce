package com.hersac.backend.modules.users.rolespermisos.models;

import com.hersac.backend.modules.users.permisos.models.Permiso;
import com.hersac.backend.modules.users.roles.models.Rol;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles_permisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolPermiso {

	@EmbeddedId
	private RolPermisoId id;

	@ManyToOne
	@MapsId("rolId")
	@JoinColumn(name = "rol_id")
	private Rol rol;

	@ManyToOne
	@MapsId("permisoId")
	@JoinColumn(name = "permiso_id")
	private Permiso permiso;

}
