package com.book.springboot.web;

import com.book.springboot.service.comments.CommentsService;
import com.book.springboot.web.dto.CommentsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/api/comments/{id}")
    public Long save(@RequestBody CommentsSaveRequestDto requestDto, @PathVariable Long postsId){
        return commentsService.save(requestDto, postsId);
    }

}
