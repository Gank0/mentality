package com.bishe.mentality.service;

import com.bishe.mentality.dao.ArticleDAO;
import com.bishe.mentality.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleDAO articleDAO;
    @Override
    public List<Article> FindAllArticle() {
        return articleDAO.FindAllArticle();
    }

    @Override
    public Article FindArticleById(Integer id) {
        return articleDAO.FindArticleById(id);
    }

    @Override
    public List<Article> FindArticleByType(Integer type) {
        return articleDAO.FindArticleByType(type);
    }

    @Override
    public void AddArticle(Article article) {
        articleDAO.AddArticle(article);
    }

    @Override
    public void updateArticleById(Article article) {
        articleDAO.updateArticleById(article);
    }
}
