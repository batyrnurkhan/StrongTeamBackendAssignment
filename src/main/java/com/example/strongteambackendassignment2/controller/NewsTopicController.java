package com.example.strongteambackendassignment2.controller;

import com.example.strongteambackendassignment2.model.NewsSource;
import com.example.strongteambackendassignment2.model.NewsTopic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/news-topics")
public class NewsTopicController {

    private List<NewsTopic> newsTopics = new ArrayList<>();
    private List<NewsSource> newsSources = new ArrayList<>();

    @GetMapping
    public List<NewsTopic> getAllNewsTopics() {
        return newsTopics;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsTopic> getNewsTopicById(@PathVariable String id) {
        for (NewsTopic nt : newsTopics) {
            if (nt.getId().equals(id)) {
                return new ResponseEntity<>(nt, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<NewsTopic> createNewsTopic(@RequestBody NewsTopic newsTopic) {
        for (NewsTopic nt : newsTopics) {
            if (nt.getId().equals(newsTopic.getId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        newsTopics.add(newsTopic);
        return new ResponseEntity<>(newsTopic, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsTopic> updateNewsTopic(@PathVariable String id, @RequestBody NewsTopic newsTopic) {
        for (NewsTopic nt : newsTopics) {
            if (nt.getId().equals(id)) {
                nt.setName(newsTopic.getName());
                nt.setSourceId(newsTopic.getSourceId());
                return new ResponseEntity<>(nt, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsTopic(@PathVariable String id) {
        for (NewsTopic nt : newsTopics) {
            if (nt.getId().equals(id)) {
                newsTopics.remove(nt);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}