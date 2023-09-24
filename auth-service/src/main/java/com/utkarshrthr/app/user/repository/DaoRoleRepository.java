package com.utkarshrthr.app.user.repository;

import com.utkarshrthr.app.user.entity.DAORole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoRoleRepository extends JpaRepository<DAORole, Integer>, RoleRepository {

}
