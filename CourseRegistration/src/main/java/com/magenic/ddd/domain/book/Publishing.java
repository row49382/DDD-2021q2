package com.magenic.ddd.domain.book;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Publishing extends AuditingBaseEntity {
    @NotNull
    private Date year;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;
}
