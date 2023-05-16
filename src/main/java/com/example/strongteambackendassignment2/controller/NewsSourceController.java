package com.example.strongteambackendassignment2.controller;

import com.example.strongteambackendassignment2.model.NewsArticle;
import com.example.strongteambackendassignment2.model.NewsSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/news-sources")
public class NewsSourceController {

    private List<NewsSource> newsSources = new ArrayList<>();

    @GetMapping
    public List<NewsSource> getAllNewsSources() {
        return newsSources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsSource> getNewsSourceById(@PathVariable String id) {
        for (NewsSource ns : newsSources) {
            if (ns.getId().equals(id)) {
                return new ResponseEntity<>(ns, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<NewsSource> createNewsSource(@RequestBody NewsSource newsSource) {
        for (NewsSource ns : newsSources) {
            if (ns.getId().equals(newsSource.getId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        newsSources.add(newsSource);
        return new ResponseEntity<>(newsSource, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsSource> updateNewsSource(@PathVariable String id, @RequestBody NewsSource newsSource) {
        for (NewsSource ns : newsSources) {
            if (ns.getId().equals(id)) {
                ns.setName(newsSource.getName());
                return new ResponseEntity<>(ns, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsSource(@PathVariable String id) {
        for (NewsSource ns : newsSources) {
            if (ns.getId().equals(id)) {
                newsSources.remove(ns);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}