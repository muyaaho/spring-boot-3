package com.example.firstproject_2.service;

import com.example.firstproject_2.dto.CommentDTO;
import com.example.firstproject_2.entity.Comment;
import com.example.firstproject_2.repository.ArticleRepository;
import com.example.firstproject_2.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDTO> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(CommentDTO::createCommentDto)
                .collect(Collectors.toList());
    }
}
