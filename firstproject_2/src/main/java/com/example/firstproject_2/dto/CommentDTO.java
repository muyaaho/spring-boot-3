package com.example.firstproject_2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDTO {
    private Long id;    // 댓글의 id
    private Long articleId; // 댓글의 부모 id(게시글 id)
    private String nickname; // 댓글 작성자
    private String body; // 댓글 본문
}
