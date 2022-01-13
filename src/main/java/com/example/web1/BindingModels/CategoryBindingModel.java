package com.example.web1.BindingModels;

import com.sun.istack.NotNull;

public class CategoryBindingModel {

    @NotNull
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
