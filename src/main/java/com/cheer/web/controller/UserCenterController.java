package com.cheer.web.controller;

import com.cheer.domain.User;
import com.cheer.service.BlogService;
import com.cheer.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserCenterController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BoardService boardService;

    @RequestMapping("delBlog")
    public String delBlog(Integer blogid,HttpSession session){
        System.out.println(blogid);
        User user = (User) session.getAttribute("user");
        String blogUsername = blogService.findBlog(blogid).getUsername();
        if(blogUsername.equals(user.getUsername())){
            blogService.delBlog(blogid);
            boardService.delBoard(blogid);
        }

        return "redirect:userCenter";
    }


}
