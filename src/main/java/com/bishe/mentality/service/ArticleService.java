package com.bishe.mentality.service;

import com.bishe.mentality.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> FindAllArticle();
    Article FindArticleById(Integer id);
    List<Article> FindArticleByType(Integer type);
    void AddArticle(Article article);
    void updateArticleById(Article article);
}
