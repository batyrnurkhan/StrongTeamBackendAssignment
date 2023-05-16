package com.example.strongteambackendassignment2.controller;

import com.example.strongteambackendassignment2.model.NewsArticle;
import com.example.strongteambackendassignment2.model.NewsSource;
import com.example.strongteambackendassignment2.model.NewsTopic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/news-articles")
public class NewsArticleController {

    private List<NewsArticle> newsArticles = new ArrayList<>();

    @GetMapping
    public List<NewsArticle> getAllNewsArticles(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return newsArticles.stream()
                .skip(pageNo * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @GetMapping("/bySource/{sourceId}")
    public List<NewsArticle> getNewsBySourceId(
            @PathVariable String sourceId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return newsArticles.stream()
                .filter(article -> sourceId.equals(article.getSourceId()))
                .skip(pageNo * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @GetMapping("/byTopic/{topicId}")
    public List<NewsArticle> getNewsByTopicId(
            @PathVariable String topicId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return newsArticles.stream()
                .filter(article -> topicId.equals(article.getTopicId()))
                .skip(pageNo * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<NewsArticle> getNewsArticleById(@PathVariable String id) {
        for (NewsArticle na : newsArticles) {
            if (na.getId().equals(id)) {
                return new ResponseEntity<>(na, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<NewsArticle> createNewsArticle(@RequestBody NewsArticle newsArticle) {
        for (NewsArticle na : newsArticles) {
            if (na.getId().equals(newsArticle.getId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        newsArticles.add(newsArticle);
        return new ResponseEntity<>(newsArticle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsArticle> updateNewsArticle(@PathVariable String id, @RequestBody NewsArticle newsArticle) {
        for (NewsArticle na : newsArticles) {
            if (na.getId().equals(id)) {
                na.setTitle(newsArticle.getTitle());
                na.setContent(newsArticle.getContent());
                na.setTopicId(newsArticle.getTopicId()); // Add this line
                return new ResponseEntity<>(na, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsArticle(@PathVariable String id) {
        for (NewsArticle na : newsArticles) {
            if (na.getId().equals(id)) {
                newsArticles.remove(na);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}