package com.example.firstproject_2.service;

import com.example.firstproject_2.dto.CommentDTO;
import com.example.firstproject_2.entity.Article;
import com.example.firstproject_2.entity.Comment;
import com.example.firstproject_2.repository.ArticleRepository;
import com.example.firstproject_2.repository.CommentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CommentDTO create(Long articleId, CommentDTO dto) {
        // 1. 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! " + "대상 게시글이 없습니다."));
        // 2. 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        // 3. 댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);
        // 4. DTO로 변환해 반환
        return CommentDTO.createCommentDto(created);
    }

    @Transactional
    public CommentDTO update(Long id, CommentDTO dto) {
        // 1. 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패!" + " 대상 댓글이 없습니다."));
        // 2. 댓글 수정
        target.patch(dto);
        // 3. DB 갱신
        Comment updated = commentRepository.save(target);
        // 4. 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDTO.createCommentDto(updated);
    }

    @Transactional
    public CommentDTO delete(Long id) {
        // 1. 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다."));
        // 2. 댓글 삭제
        commentRepository.delete(target);
        // 3. 삭제 댓글을 DTO로 변환 및 반환
        return CommentDTO.createCommentDto(target);
    }
}
