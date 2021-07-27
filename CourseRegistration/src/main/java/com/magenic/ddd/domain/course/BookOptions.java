package com.magenic.ddd.domain.course;

import com.magenic.ddd.domain.book.Book;
import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
public class BookOptions extends AuditingBaseEntity {
    @ElementCollection(targetClass = Book.class)
    Set<Book> requiredBooks;

    @ElementCollection(targetClass = Book.class)
    Set<Book> optionalBooks;

    @ElementCollection(targetClass = Book.class)
    List<Set<Book>> alternativeBooks;

    public BookOptions(Set<Book> requiredBooks, Set<Book> optionalBooks, List<Set<Book>> alternativeBooks) {
        this.requiredBooks = requiredBooks;
        this.optionalBooks = optionalBooks;
        this.alternativeBooks = alternativeBooks;
    }

    public Set<Book> getRequiredBooks() {
        return requiredBooks;
    }

    public void setRequiredBooks(Set<Book> requiredBooks) {
        this.requiredBooks = requiredBooks;
    }

    public Set<Book> getOptionalBooks() {
        return optionalBooks;
    }

    public void setOptionalBooks(Set<Book> optionalBooks) {
        this.optionalBooks = optionalBooks;
    }

    public List<Set<Book>> getAlternativeBooks() {
        return alternativeBooks;
    }

    public void setAlternativeBooks(List<Set<Book>> alternativeBooks) {
        this.alternativeBooks = alternativeBooks;
    }
}
