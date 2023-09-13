package com.utkarshrthr.app.user.controller;

import com.utkarshrthr.app.user.dto.RoleRequest;
import com.utkarshrthr.app.user.dto.RoleResponse;
import com.utkarshrthr.app.user.service.AppRoleService;
import com.utkarshrthr.app.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private AppRoleService service;

    @PostMapping
    public ResponseEntity<Object> addNewRole(@RequestBody @Valid RoleRequest request){
        String message = service.addRole(request);
        return ApiResponse.getResponse(HttpStatus.CREATED, message);
    }

    @PutMapping
    public ResponseEntity<Object> updateRole(@RequestBody @Valid RoleRequest request){
        service.updateRole(request);
        return ApiResponse.getResponse(HttpStatus.OK, "Role's details updated successfully.");
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getRole(@PathVariable String id){
        RoleResponse role = service.getRole(id);
        return ApiResponse.getResponse(HttpStatus.OK, role);
    }

    @GetMapping
    public ResponseEntity<Object> getAllRoles(){
        List<RoleResponse> roles = service.getAllRoles();
        return ApiResponse.getResponse(HttpStatus.OK, roles);
    }

    @GetMapping("search")
    public ResponseEntity<Object> searchRoles(@RequestParam String query){
        List<RoleResponse> roles = service.searchRoles(query);
        return ApiResponse.getResponse(HttpStatus.OK, roles);
    }
}
