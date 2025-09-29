package com.hersac.backend.modules.users.rolespermisos.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolPermisoId implements Serializable {

	private Long rolId;

	private Long permisoId;

}
