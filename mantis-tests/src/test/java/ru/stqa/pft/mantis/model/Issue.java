package ru.stqa.pft.mantis.model;

public class Issue {

    private int id;
    private String summari;
    private String description;
    private Project project;


    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public Issue withSummari(String summari) {
        this.summari = summari;
        return this;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }


    public String getDescription() {
        return description;
    }


    public Project getProject() {
        return project;
    }

    public int getId() {
        return id;
    }

    public String getSummari() {
        return summari;
    }


}