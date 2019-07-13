package com.cheer.web.controller;

import com.cheer.domain.Blog;
import com.cheer.domain.Board;
import com.cheer.domain.User;
import com.cheer.service.BlogService;
import com.cheer.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BlogService blogService;


    @PostMapping("sendBoard")
    public String sendBoard(Board  board, HttpSession session){
        String fmt = "yyyyMM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String dateStr = sdf.format(new Date());
        int size = boardService.getBoard().size();
        Blog blog = (Blog) session.getAttribute("blog");
        User user = (User) session.getAttribute("user");

        board.setBoardid(size+1);
        board.setBlogid(blog.getBlogid());
        board.setBoardtime(dateStr);
        board.setUseravatar(user.getAvatar());
        board.setUsername(user.getUsername());
        //每增加一条留言，数据库的sumbd加一
        int i=blog.getSumbd();
        blog.setSumbd(i+1);
        System.out.println(blog);
         blogService.updateBlog(blog);

        System.out.println(board);
        boardService.insertBoard(board);

        List<Board> boards=boardService.findBoard(blog.getBlogid());
        session.setAttribute("boards",boards);
        return "redirect:blogBody";
    }
}
