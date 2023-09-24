package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.exception.RoleNotFoundException;
import com.utkarshrthr.app.user.dto.RoleRequest;
import com.utkarshrthr.app.user.dto.RoleResponse;
import com.utkarshrthr.app.user.entity.DAORole;
import com.utkarshrthr.app.user.repository.DaoRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AppRoleService implements RoleService {

    private final DaoRoleRepository repository;

    public AppRoleService(DaoRoleRepository repository) {
        this.repository = repository;
    }


    @Override
    public Integer addRole(RoleRequest request) {
        DAORole role = new DAORole();
        BeanUtils.copyProperties(request, role);
        DAORole newRole = repository.save(role);
        return newRole.getId();
    }

    @Override
    public String updateRole(RoleRequest request) {
        return "Role updated successfully";
    }

    @Override
    public String deleteRole(Integer roleId) {
        // TODO -> Roles can not be deleted if it is associated to any user
        // TODO -> throw custom UnsupportedOperationException or InvalidStateException
        return "Role deleted successfully";
    }

    @Override
    public RoleResponse getRole(Integer id) {
        DAORole role = repository
              .findById(id)
              .orElseThrow(() -> new RoleNotFoundException("No role exists for id: "+id));
        RoleResponse response = new RoleResponse();
        BeanUtils.copyProperties(role, response);
        return response;
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        List<DAORole> roles = repository.findAll();
        if(CollectionUtils.isEmpty(roles))
            return Collections.emptyList();
        List<RoleResponse> responses = new ArrayList<>();
        roles.forEach(role -> {
            RoleResponse response = new RoleResponse();
            BeanUtils.copyProperties(role, response);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<RoleResponse> searchRoles(String query) {
        // TODO -> Roles can be searched by name only
        // TODO -> API should return 204-No-Content if no records found
        return Collections.emptyList();
    }
}
