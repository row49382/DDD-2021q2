package com.magenic.ddd.domain.address;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class USAddress extends Address {
    @NotEmpty
    private String state;

    @NotEmpty
    private String zipCode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String getFullAddress() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getFullAddress());
        sb.append(", ");

        sb.append("State: ");
        sb.append(this.state);
        sb.append(", ");

        sb.append("ZipCode: ");
        sb.append(this.zipCode);

        return sb.toString();
    }
}
