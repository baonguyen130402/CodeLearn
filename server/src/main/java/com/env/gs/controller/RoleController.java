package com.env.gs.controller;

import com.env.gs.domain.Role;
import com.env.gs.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v3/role")
@Tag(name = "Role-API")
public class RoleController
{
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> getAll(){
        return ResponseEntity.ok(roleService.getAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Role> getById(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getById(id));
    }
}
