package com.cheer.web.controller;

import com.cheer.domain.Blog;
import com.cheer.domain.Board;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BoardService boardService;

    @RequestMapping("sendBlog")
    public String sendBlog(Blog blog, HttpSession session){
        //size表示blog表中blogid的最大值
        int size=0;
        String fmt = "yyyyMM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String dateStr = sdf.format(new Date());
       //获取blog表中blogid的最大值并赋值给size
        List<Blog> blogList = blogService.getBlog();
        for (Blog blog1 : blogList) {
            if(blog1.getBlogid()>size){
                size=blog1.getBlogid();
            }
        }
        User user = (User) session.getAttribute("user");
        blog.setBlogid(size+1);
        blog.setBlogtime(dateStr);
        blog.setUsername(user.getUsername());
        blog.setUseravatar(user.getAvatar());
        System.out.println(blog);
        blogService.insertBlog(blog);
        List<Blog> blogs=blogService.getBlog();
        session.setAttribute("blogs",blogs);
        return "redirect:index";
    }

    @GetMapping("blogBody")
    public String blogBody(){
        return "blogBody";
    }

    @GetMapping("clickBlog")
    public String clickBlog( int blogid,HttpSession session){
        Blog blog = blogService.findBlog(blogid);
        System.out.println(blog);
        session.setAttribute("blog",blog);

        List<Board> boards = boardService.findBoard(blogid);
        session.setAttribute("boards",boards);
        return "redirect:blogBody";
    }




}
