package com.example.firstproject_2.service;

import com.example.firstproject_2.dto.CommentDTO;
import com.example.firstproject_2.entity.Comment;
import com.example.firstproject_2.repository.ArticleRepository;
import com.example.firstproject_2.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDTO> comments(Long articleId) {
        // 1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // 2. 엔티티 -> DTO 변환
        List<CommentDTO> dtos = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            Comment c = comments.get(i);
            CommentDTO dto = CommentDTO.createCommentDto(c);
            dtos.add(dto);
        }
        // 3. 결과 반환
        return dtos;
    }
}
