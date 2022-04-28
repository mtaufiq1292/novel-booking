package com.shop.novelbooking;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Novel {

    private @Id @GeneratedValue Long id;
    private String name;
    private String author;

    Novel() {
    }

    Novel(String name, String author) {

        this.name = name;
        this.author = author;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getauthor() {
        return this.author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Novel))
            return false;
        Novel Novel = (Novel) o;
        return Objects.equals(this.id, Novel.id) && Objects.equals(this.name, Novel.name)
                && Objects.equals(this.author, Novel.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.author);
    }

    @Override
    public String toString() {
        return "Novel{" + "id=" + this.id + ", name='" + this.name + '\'' + ", author='" + this.author + '\'' + '}';
    }
}
