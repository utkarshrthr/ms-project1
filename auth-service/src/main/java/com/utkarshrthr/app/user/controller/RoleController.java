package com.utkarshrthr.app.user.controller;

import com.utkarshrthr.app.user.dto.RoleRequest;
import com.utkarshrthr.app.user.dto.RoleResponse;
import com.utkarshrthr.app.user.service.AppRoleService;
import com.utkarshrthr.app.util.ApiResponse;
import com.utkarshrthr.app.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(AppConstants.API_VERSION + "/roles")
public class RoleController {

    private final AppRoleService service;

    public RoleController(AppRoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> addNewRole(@RequestBody @Valid RoleRequest request){
        Integer roleId = service.addRole(request);

        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Timestamp(System.currentTimeMillis()));
        map.put("status", HttpStatus.CREATED.value());

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(roleId)
                .toUri();

        /*WebFluxLinkBuilder
                .linkTo(RoleController.class)
                .slash(roleId.toString()).withSelfRel();*/

        return ResponseEntity.created(uri).body(map);
    }

    @PutMapping
    public ResponseEntity<Object> updateRole(@RequestBody @Valid RoleRequest request){
        service.updateRole(request);
        return ApiResponse.getResponse(HttpStatus.OK, "Role's details updated successfully.");
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getRole(@PathVariable Integer id){
        RoleResponse role = service.getRole(id);
        return ApiResponse.getResponse(HttpStatus.OK, role);
    }

    @GetMapping
    public ResponseEntity<Object> getAllRoles(){
        List<RoleResponse> roles = service.getAllRoles();
        return CollectionUtils.isEmpty(roles) ?
            ResponseEntity.noContent().build():
            ApiResponse.getResponse(HttpStatus.OK, roles);
    }

    @GetMapping("search")
    public ResponseEntity<Object> searchRoles(@RequestParam String query){
        List<RoleResponse> roles = service.searchRoles(query);
        return ApiResponse.getResponse(HttpStatus.OK, roles);
    }
}
