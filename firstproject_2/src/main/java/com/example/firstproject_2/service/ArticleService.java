package com.example.firstproject_2.service;

import com.example.firstproject_2.entity.Article;
import com.example.firstproject_2.repository.ArticleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
}
