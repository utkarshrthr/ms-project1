package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.user.dto.RoleRequest;
import com.utkarshrthr.app.user.dto.RoleResponse;

import java.util.List;

public interface RoleService {

    Integer addRole(RoleRequest request);

    String updateRole(RoleRequest request);

    String deleteRole(Integer roleId);

    RoleResponse getRole(Integer id);

    List<RoleResponse> getAllRoles();

    List<RoleResponse> searchRoles(String query);
}
