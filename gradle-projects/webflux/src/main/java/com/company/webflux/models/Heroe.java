package com.company.webflux.models;

public class Heroe {

    public Heroe() {

    }

    public Heroe(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Heroe{" +
                "name='" + name + '\'' +
                '}';
    }
}
