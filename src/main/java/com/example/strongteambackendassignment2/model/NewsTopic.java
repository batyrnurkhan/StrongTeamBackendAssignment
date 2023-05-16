package com.example.strongteambackendassignment2.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
public class NewsTopic {
    private String id;
    private String name;
    private String sourceId;

    // constructor, getters and setters

    public NewsTopic() {
    }

    public NewsTopic(String id, String name, String sourceId) {
        this.id = id;
        this.name = name;
        this.sourceId = sourceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}