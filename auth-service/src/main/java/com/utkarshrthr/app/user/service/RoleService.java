package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.user.dto.RoleRequest;
import com.utkarshrthr.app.user.dto.RoleResponse;

import java.util.List;

public interface RoleService {

    String addRole(RoleRequest request);

    String updateRole(RoleRequest request);

    String deleteRole(String roleId);

    RoleResponse getRole(String name);

    List<RoleResponse> getAllRoles();

    List<RoleResponse> searchRoles(String query);
}
