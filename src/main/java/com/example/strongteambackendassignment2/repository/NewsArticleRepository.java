package com.example.strongteambackendassignment2.repository;
import com.example.strongteambackendassignment2.model.NewsArticle;
import com.example.strongteambackendassignment2.model.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, String> {
    List<NewsSource> findAllNewsSources();
    long countByNewsSource(NewsSource source);
}
