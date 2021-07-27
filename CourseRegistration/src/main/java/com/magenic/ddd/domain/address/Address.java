package com.magenic.ddd.domain.address;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public abstract class Address extends AuditingBaseEntity {
    @NotEmpty
    private String address1;
    private String address2;

    @NotEmpty
    private String country;

    @NotEmpty
    private String city;

    public String getFullAddress() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address1: ");
        sb.append(this.address1);
        sb.append(", ");

        sb.append("Address2: ");
        sb.append(this.address2);
        sb.append(", ");

        sb.append("Country: ");
        sb.append(this.country);
        sb.append(", ");

        sb.append("City: ");
        sb.append(this.city);

        return sb.toString();
    }
}
