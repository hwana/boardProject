package com.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private String content;
    private Long postsId;

    @Builder
    public CommentsSaveRequestDto(String content, Long postsId){
        this.content = content;
        this.postsId = postsId;
    }

}
