package com.waste.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    public Role() {}

    public Integer getId() { return id; }
    public String getRoleName() { return roleName; }

    public void setId(Integer id) { this.id = id; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}
