package com.hersac.backend.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.controllers.exceptions.ItemNotFoundException;
import com.hersac.backend.models.Usuarios;
import com.hersac.backend.repositories.UsuariosRepository;
import com.hersac.backend.services.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository usuarioRepo;

    @Override
    public Optional<List<Usuarios>> getUsuarios() {
        return Optional.of(usuarioRepo.findAll());
    }

    @Override
    public Optional<Usuarios> getUsuarioById(Long id) {
        Optional<Usuarios> usuario = usuarioRepo.findById(id);
        if(!usuario.isPresent())
            throw new ItemNotFoundException("Usuario no encontrado");
        return usuario;
    }

    @Override
    public Optional<String> addUsuario(Usuarios usuario){
        usuarioRepo.save(usuario);
        return Optional.of("Usuario creado correctamente");
    }

    @Override
    public Optional<String> updateUsuario(Long id, Usuarios usuario){
        Optional<Usuarios> usuarioAnterior = usuarioRepo.findById(id);
        if(!usuarioAnterior.isPresent())
            throw new ItemNotFoundException("Usuario no encontrado");
        usuarioAnterior.get().setEmail(usuario.getEmail());
        usuarioAnterior.get().setPassword(usuario.getPassword());
        usuarioAnterior.get().setPrimerNombre(usuario.getPrimerNombre());
        usuarioAnterior.get().setSegundoNombre(usuario.getSegundoNombre());
        usuarioAnterior.get().setPrimerApellido(usuario.getPrimerApellido());
        usuarioAnterior.get().setSegundoApellido(usuario.getSegundoApellido());
        usuarioAnterior.get().setIdentificacion(usuario.getIdentificacion());
        usuarioAnterior.get().setDireccion(usuario.getDireccion());
        usuarioAnterior.get().setCumpleaños(usuario.getCumpleaños());

        usuarioRepo.save(usuarioAnterior.get());
        return Optional.of("Usuario actualizado correctamente");
    }
    
    @Override
    public Optional<String> deleteUsuarioById(Long id){
        Optional<Usuarios> usuario = usuarioRepo.findById(id);
        if(!usuario.isPresent())
            throw new ItemNotFoundException("Usuario no encontrado");
        usuarioRepo.deleteById(id);
        return Optional.of("Usuario eliminado correctamente");
    }
}
