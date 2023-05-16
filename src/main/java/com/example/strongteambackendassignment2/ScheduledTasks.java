package com.example.strongteambackendassignment2;

import com.example.strongteambackendassignment2.model.NewsSource;
import com.example.strongteambackendassignment2.repository.NewsArticleRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class ScheduledTasks {

    private final NewsArticleRepository newsArticleRepository;

    public ScheduledTasks(NewsArticleRepository newsArticleRepository) {
        this.newsArticleRepository = newsArticleRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void reportCurrentNewsCount() {
        List<NewsSource> sources = newsArticleRepository.findAllNewsSources();
        try (PrintWriter writer = new PrintWriter(new FileWriter("newsCount.txt", true))) {
            for (NewsSource source : sources) {
                long count = newsArticleRepository.countByNewsSource(source);
                writer.println(source.getName() + ": " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
