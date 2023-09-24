package com.utkarshrthr.app.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class DAORole extends MasterEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Column(name = "role_type", nullable = false)
    private String type;

    @Column(nullable = false)
    private boolean isActive = true;
}
