package com.hersac.backend.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

	Date fechaHoy = new Date();

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		List<Rol> defaultRoles = Arrays.asList(new Rol(null, "Administrador"));
		rolesRepo.saveAll(defaultRoles);

		Date fechaHoy = new Date();
		Rol admin = rolesRepo.findById(1L).get();

		List<Usuario> defaultUsuarios = Arrays
			.asList(new Usuario(null, "admin", "admin", "Admin", "", "", "", "", fechaHoy, "", admin));
		usuariosRepo.saveAll(defaultUsuarios);
	}

}
