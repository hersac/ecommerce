package com.hersac.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.models.Roles;
import com.hersac.backend.services.RolesService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesServ;

    @GetMapping
    public Optional<List<Roles>> getRoles() {
        return rolesServ.getRoles();
    }

    @GetMapping("/{id}")
    public Optional<Roles> getRoleById(@PathVariable Long id) {
        return rolesServ.getRolById(id);
    }

    @PostMapping
    public Optional<String> addRoles(@RequestBody Roles newRole) {
        return rolesServ.addRol(newRole);
    }

    @PutMapping("/{id}")
    public Optional<String> updateRole(@PathVariable Long id,
            @RequestBody Roles newData) {
        return rolesServ.updateRol(id, newData);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteRole(@PathVariable Long id) {
        return rolesServ.deleteRolById(id);
    }
}
