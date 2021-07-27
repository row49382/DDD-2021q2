package com.magenic.ddd.domain.user;

import com.magenic.ddd.domain.shared.constant.PayType;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public abstract class Employee extends User {
    @NotNull
    private PayType payType;

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public abstract BigDecimal calculatePay();
}
