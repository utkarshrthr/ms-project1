package com.utkarshrthr.app.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_role")
public class DAORole extends MasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;

    @Column(name = "role_description")
    private String description;

    @Column(name = "role_type")
    private String type;

    private boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
