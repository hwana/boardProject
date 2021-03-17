package com.book.springboot.domain.comments;

import com.book.springboot.domain.posts.BaseTimeEntity;
import com.book.springboot.domain.posts.Posts;
import com.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENTS_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(columnDefinition = "integer default 0")
    private int delYn;

    @ManyToOne
    @JoinColumn(name = "POSTS_ID")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Comments(Posts posts, String content, int delYn){
        this.content = content;
        this.delYn = delYn;
        this.posts = posts;
    }

//    public void setPosts(Posts posts) {
//        this.posts = posts;
//    }

    public void setUser(User user) {
        this.user = user;
    }

}
