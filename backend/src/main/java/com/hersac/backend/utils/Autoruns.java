package com.hersac.backend.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hersac.backend.models.Usuarios;
import com.hersac.backend.repositories.UsuariosRepository;

import jakarta.transaction.Transactional;

@Component
public class Autoruns implements CommandLineRunner {
    @Autowired
    private UsuariosRepository usuariosRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Usuarios> defaultUsuarios = Arrays.asList(
                new Usuarios(null, "admin", "admin", "Admin", "", "", "", "", "", null, "")
                );
        usuariosRepo.saveAll(defaultUsuarios);
    }
}
