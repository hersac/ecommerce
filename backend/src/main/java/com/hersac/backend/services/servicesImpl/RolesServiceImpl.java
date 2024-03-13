package com.hersac.backend.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.controllers.exceptions.ItemNotFoundException;
import com.hersac.backend.models.Roles;
import com.hersac.backend.repositories.RolesRepository;
import com.hersac.backend.services.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
    @Autowired
    private RolesRepository rolesRepo;

    @Override
    public Optional<List<Roles>> getRoles(){
        return Optional.of(rolesRepo.findAll());
    }

    @Override
    public Optional<Roles> getRolById(Long id){
        Optional<Roles> rol = rolesRepo.findById(id);
        if(!rol.isPresent())
            throw new ItemNotFoundException("Rol no encontrado");
        return rol;
    }

    @Override
    public Optional<String> addRol(Roles rol){
        rolesRepo.save(rol);
        return Optional.of("Rol creado correctamente");
    }

    @Override
    public Optional<String> updateRol(Long id, Roles rol){
        Optional<Roles> rolAnterior = rolesRepo.findById(id);
        if(!rolAnterior.isPresent())
            throw new ItemNotFoundException("Rol no encontrado");
        rolAnterior.get().setNombreRol(rol.getNombreRol());

        rolesRepo.save(rolAnterior.get());
        return Optional.of("Rol actualizado correctamente");
    }

    @Override
    public Optional<String> deleteRolById(Long id){
        Optional<Roles> usuario = rolesRepo.findById(id);
        if(!usuario.isPresent())
            throw new ItemNotFoundException("Rol no encontrado");
        rolesRepo.deleteById(id);
        return Optional.of("Rol eliminado correctamente");
    }
}
