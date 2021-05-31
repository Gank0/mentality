package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Article;

import java.util.List;

public interface ArticleDAO {
    List<Article> FindAllArticle();
    Article FindArticleById(Integer id);
    List<Article> FindArticleByType(Integer type);
    void AddArticle(Article article);
    void updateArticleById(Article article);
}
