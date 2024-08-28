package org.example.proyectofinalspringsecurity.controller;

import org.example.proyectofinalspringsecurity.model.Permission;
import org.example.proyectofinalspringsecurity.model.Role;
import org.example.proyectofinalspringsecurity.service.IPermissionService;
import org.example.proyectofinalspringsecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permiService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Role> createRole(@RequestBody Role role) throws Exception {
        Set<Permission> permiList = new HashSet<Permission>();
        Permission readPermission;

        if(role.getPermissionList().isEmpty()){
            throw new Exception("Error");
        }
        for (Permission per : role.getPermissionList()) {
            readPermission = permiService.findById(per.getId()).orElse(null);
            if (readPermission != null) {
                permiList.add(readPermission);
            }
        }

        role.setPermissionList(permiList);
        Role newRole = roleService.save(role);
        return ResponseEntity.ok(newRole);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {

        Role rol = roleService.findById(id).orElse(null);
        if (rol!=null) {
            rol = role;
            rol.setId(id);
        }
        roleService.update(rol);
        return ResponseEntity.ok(rol);

    }

}
