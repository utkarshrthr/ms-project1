package com.utkarshrthr.app.user.repository;

import com.utkarshrthr.app.user.entity.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<DAOUser, String>, UserRepository {

}
