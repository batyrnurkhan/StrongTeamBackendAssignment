package com.example.strongteambackendassignment2.model;

public class NewsArticle {
    private String id;
    private String title;
    private String content;
    private String topicId;
    private String sourceId; // New field

    // constructor, getters and setters

    public NewsArticle() {
    }

    public NewsArticle(String id, String title, String content, String topicId, String sourceId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.topicId = topicId;
        this.sourceId = sourceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getSourceId() { // New getter
        return sourceId;
    }

    public void setSourceId(String sourceId) { // New setter
        this.sourceId = sourceId;
    }
}