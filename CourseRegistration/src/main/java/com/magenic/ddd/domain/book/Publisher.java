package com.magenic.ddd.domain.book;

import com.magenic.ddd.domain.address.Address;
import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Publisher extends AuditingBaseEntity {
    @NotEmpty
    String name;

    @NotNull
    @OneToOne(targetEntity = Address.class)
    Address address;

    @OneToMany(mappedBy = "publisher")
    List<Publishing> publishings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Publishing> getPublishings() {
        return publishings;
    }

    public void setPublishings(List<Publishing> publishings) {
        this.publishings = publishings;
    }
}
