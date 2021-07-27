package com.magenic.ddd.domain.book;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Entity
public abstract class Book extends AuditingBaseEntity {
    @NotEmpty
    String title;

    @NotEmpty
    @ElementCollection(targetClass = String.class)
    List<String> authors;

    @Min(0)
    BigDecimal cost;

    @NotEmpty
    @OneToMany(mappedBy = "book")
    List<Publishing> publishings;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<Publishing> getPublishings() {
        return publishings;
    }

    public void setPublishings(List<Publishing> publishings) {
        this.publishings = publishings;
    }

    public BigDecimal calculateCostForCurrentRegion() {
        // in real app, access local to calculate based on region
        return BigDecimal.valueOf(10.0);
    }
}
