package com.example.web1.Entities;

import javax.persistence.*;
import java.awt.*;
import java.io.File;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    private String title;
    private String description;
    private Integer pagesCount;
    private byte[] content;
    private Author author;
    private Set<Category> categories;
    private String yearPublished;
    private byte[] cover;
    private String coverBase64;

    public Book() {
    }



    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    @Column(columnDefinition = "MEDIUMBLOB")
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @ManyToOne
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany()
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Column
    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Column(columnDefinition = "LONGBLOB")
    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    @Transient
    public String getCoverBase64() {
        return coverBase64;
    }

    public void setCoverBase64(String coverBase64) {
        this.coverBase64 = coverBase64;
    }
}
