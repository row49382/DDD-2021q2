package com.magenic.ddd.domain.user;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Staff extends Employee {
    @Override
    public BigDecimal calculatePay() {
        return null;
    }
}
