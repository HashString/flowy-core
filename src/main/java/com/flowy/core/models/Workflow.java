package com.flowy.core.models;

public class Workflow {

    private Long id;
    private String name;
    private Item manages;
    private String description;

    public Workflow(String name, Item manages, String description) {
        this.name = name;
        this.manages = manages;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
