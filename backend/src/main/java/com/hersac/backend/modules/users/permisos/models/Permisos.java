package com.hersac.backend.modules.users.permisos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Permisos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long permisoId;

	private String nombre;

}
