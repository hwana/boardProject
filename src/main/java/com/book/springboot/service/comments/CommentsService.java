package com.book.springboot.service.comments;

import com.book.springboot.domain.comments.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

}
