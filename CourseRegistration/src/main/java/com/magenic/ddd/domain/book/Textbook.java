package com.magenic.ddd.domain.book;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Textbook extends Book {
    @NotEmpty
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
