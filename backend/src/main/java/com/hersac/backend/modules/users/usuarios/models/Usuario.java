package com.hersac.backend.modules.users.usuarios.models;

import java.util.Date;

import com.hersac.backend.globals.config.UsuarioDetails;
import com.hersac.backend.modules.users.roles.models.Rol;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String email;

	private String password;

	private String primerNombre;

	private String segundoNombre;

	private String primerApellido;

	private String segundoApellido;

	private String identificacion;

	private Date cumpleaños;

	private String direccion;

	@OneToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;

	public UsuarioDetails toUserDetails() {
		return new UsuarioDetails(this);
	}

}
