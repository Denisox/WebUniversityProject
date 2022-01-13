package com.example.web1.BindingModels;

import com.sun.istack.NotNull;

public class AuthorBindingModel {

    @NotNull
    private String fullName;

    private boolean isAlive;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
