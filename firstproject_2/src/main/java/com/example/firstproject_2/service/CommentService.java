package com.example.firstproject_2.service;

import com.example.firstproject_2.repository.ArticleRepository;
import com.example.firstproject_2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;
}
