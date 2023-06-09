package com.example.strongteambackendassignment2.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
public class NewsSource {

    private String id;
    private String name;

    public NewsSource(String id, String name) {
        this.id = id;
        this.name = name;
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
}
