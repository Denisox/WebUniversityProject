package com.example.web1.BindingModels;

import com.example.web1.Entities.Author;
import com.example.web1.Entities.Book;
import com.example.web1.Entities.Category;
import com.sun.istack.NotNull;

import java.io.File;


public class BookBindingModel {
    @NotNull
    private String title;

    private String description;

    @NotNull
    private Integer pagesCount;

    @NotNull
    private File content;

    private String yearPublished;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public File getContent() {
        return content;
    }

    public void setContent(File content) {
        this.content = content;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }
}
