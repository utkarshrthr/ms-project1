package com.utkarshrthr.app.user.repository;

import com.utkarshrthr.app.user.entity.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DAOUserRepository extends JpaRepository<DAOUser, String>, UserRepository {

    List<DAOUser> findDAOUserByUsername(String username);
}
