package com.utkarshrthr.app.user.repository;

import com.utkarshrthr.app.user.entity.DAORole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<DAORole, Integer>, RoleRepository {

}
