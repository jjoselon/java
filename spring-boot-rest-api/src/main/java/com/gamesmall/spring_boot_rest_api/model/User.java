package com.gamesmall.spring_boot_rest_api.model;

public class User {
    private Long id;
    private String name;

    // Constructor, getters y setters
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
