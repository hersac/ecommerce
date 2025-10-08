package com.hersac.backend.utils;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.hersac.backend.modules.users.roles.models.Rol;
import com.hersac.backend.modules.users.roles.models.repositories.RolRepository;
import com.hersac.backend.modules.users.usuarios.models.Usuario;
import com.hersac.backend.modules.users.usuarios.models.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Component
public class Autoruns implements CommandLineRunner {

	private final RolRepository rolesRepo;

	private final UsuarioRepository usuariosRepo;

	public Autoruns(UsuarioRepository usuariosRepo, RolRepository rolesRepo) {
		this.usuariosRepo = usuariosRepo;
		this.rolesRepo = rolesRepo;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Rol adminRol = rolesRepo.findByNombreRol("Administrador").orElseGet(() -> {
			Rol nuevoRol = new Rol(null, "Administrador");
			return rolesRepo.save(nuevoRol);
		});

		String prueba = Base64.getEncoder().encodeToString("admin:admin".getBytes());
		System.out.println(prueba);

		Optional<Usuario> adminExistente = usuariosRepo.findByEmail("admin");
		String hashedPassword = BCryptUtil.hashPassword("admin");

		if (adminExistente.isEmpty()) {
			Date fechaHoy = new Date();
			Usuario admin = new Usuario(null, "admin", hashedPassword, "Admin", "", "", "", "", fechaHoy, "", adminRol);
			usuariosRepo.save(admin);
		}
	}

}
