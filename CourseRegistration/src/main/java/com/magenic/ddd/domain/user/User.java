package com.magenic.ddd.domain.user;

import com.magenic.ddd.domain.address.Address;
import com.magenic.ddd.domain.shared.AuditingBaseEntity;
import com.magenic.ddd.domain.shared.constant.DepartmentType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public abstract class User extends AuditingBaseEntity {
    @NotEmpty
    private String name;

    @NotNull
    private DepartmentType department;

    @NotEmpty
    private String email;

    @NotNull
    @OneToOne(targetEntity = Address.class)
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentType department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}