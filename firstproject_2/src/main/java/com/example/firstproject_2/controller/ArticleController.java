package com.example.firstproject_2.controller;

import com.example.firstproject_2.dto.ArticleForm;
import com.example.firstproject_2.entity.Article;
import com.example.firstproject_2.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(form.toString());
        // 2. 리파지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
}
