package com.book.springboot.web;

import com.book.springboot.config.auth.LoginUser;
import com.book.springboot.config.auth.dto.SessionUser;
import com.book.springboot.service.posts.PostsService;
import com.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    //메인페이지
    @GetMapping("/")
    public String index(Model model,
                        @LoginUser SessionUser user) {
         if (user != null) {
            model.addAttribute("name", user.getName());
        }
        return "index";
    }

    //등록페이지
    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){
        if (user != null) {
            model.addAttribute("name", user.getName());
        }
        return "posts-save";
    }

    //상세조회페이지
    @GetMapping("/posts/view/{id}")
    public String postsView(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        postsService.updateCount(id);
        model.addAttribute("post", dto);
        return "posts-view";
    }

    //수정페이지
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
