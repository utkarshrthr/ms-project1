package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.user.dto.RoleRequest;
import com.utkarshrthr.app.user.dto.RoleResponse;
import com.utkarshrthr.app.user.entity.DAORole;
import com.utkarshrthr.app.user.repository.AppRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements RoleService {

    @Autowired
    private AppRoleRepository repository;

    @Override
    public String addRole(RoleRequest request) {
        DAORole role = new DAORole();
        BeanUtils.copyProperties(request, role);
        repository.save(role);
        return "Role added successfully";
    }

    @Override
    public String updateRole(RoleRequest request) {
        return "Role updated successfully";
    }

    @Override
    public String deleteRole(String roleId) {
        // TODO -> Roles can not be deleted if it is associated to any user
        // TODO -> throw custom UnsupportedOperationException or InvalidStateException
        return "Role deleted successfully";
    }

    @Override
    public RoleResponse getRole(String name) {
        // TODO -> throw custom RoleNotFoundException
        return null;
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        // TODO -> API should return 204-No-Content if no records found
        return null;
    }

    @Override
    public List<RoleResponse> searchRoles(String query) {
        // TODO -> Roles can be searched by name only
        // TODO -> API should return 204-No-Content if no records found
        return null;
    }
}
