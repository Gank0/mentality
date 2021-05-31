package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Article {
    private Integer id;
    private String article_Name;
    private Integer article_category;
    private String article_content;
    private Date article_Time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle_Name() {
        return article_Name;
    }

    public void setArticle_Name(String article_Name) {
        this.article_Name = article_Name;
    }

    public Integer getArticle_category() {
        return article_category;
    }

    public void setArticle_categoryl(Integer article_category) {
        this.article_category = article_category;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Date getArticle_Time() {
        return article_Time;
    }

    public void setArticle_Time(Date article_Time) {
        this.article_Time = article_Time;
    }
}
