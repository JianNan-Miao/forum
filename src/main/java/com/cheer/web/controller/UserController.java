package com.cheer.web.controller;

import com.cheer.domain.Blog;
import com.cheer.domain.Board;
import com.cheer.domain.Info;
import com.cheer.domain.User;
import com.cheer.domain.vo.BlogVo;
import com.cheer.service.BlogService;
import com.cheer.service.BoardService;
import com.cheer.service.UserService;
import com.cheer.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private BoardService boardService;


    @RequestMapping("index")
    public String index(HttpSession session){
        List<Blog> blogs = blogService.getBlog();
        //获取当前热门主题话题
        List<Blog> hotBlog=new ArrayList<>();
        for (Blog blog : blogs) {
            List<Board> boardList = boardService.findBoard(blog.getBlogid());
            if(boardList.size()>1){
                hotBlog.add(blog);
            }

        }
        //更新首页blog展示数据
        session.setAttribute("blogs",blogs);
        //热门主题
        session.setAttribute("hotBlog",hotBlog);
        //社区运营状况
        List<User> userList = userService.getUserList();
        List<Blog> blogList=blogService.getBlog();
        List<Board> boardList = boardService.getBoard();
        Info info=new Info(userList.size(),blogList.size(),boardList.size());
        session.setAttribute("info",info);
        return "index";
    }

    @RequestMapping("regist")
    public String registUser(){
        return "regist";
    }

    @PostMapping("regist")
    public  String registUser(MultipartFile upload, User user, HttpServletRequest request) throws Exception {
        String src=null;
        String originalFilename = upload.getOriginalFilename();
        if (user!=null&&originalFilename!=null) {
             src="c:/avatar/";
            String newFilename=user.getUsername()+originalFilename;
            System.out.println(newFilename);
            File file=new File(src,newFilename);
            upload.transferTo(file);
            //将日期转为string
            String fmt = "yyyyMM-dd HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            String dateStr = sdf.format(new Date());
            int size = userService.getUserList().size();
            user.setUserid(size+1);
            user.setAvatar(newFilename);
            user.setRegisttime(dateStr);
            System.out.println(user);
            userService.insertUser(user);
        }
        String realPath = request.getServletContext().getRealPath("/imgs");
        String dest = realPath + "/" + user.getAvatar();
        File avatar=new File(dest);
        if(!avatar.exists()){
            String newSrc = src+ user.getAvatar();
            IOUtils.copy(newSrc, dest);
        }
        return "redirect:login";
    }


    @RequestMapping("login")
    public String loginUser(){
        return "login";
    }

    @PostMapping("login")
    public String loginUser(User user, HttpSession session){
        User user1 = userService.getUser(user.getUsername(), user.getPassword());
        System.out.println(user1);
        if(user1==null){
            return "login";
        }else{
            List<Blog> blogs = blogService.getBlog();
//            List<Board> boards = boardService.getBoard();
            session.setAttribute("blogs",blogs);
            session.setAttribute("user",user1);

            return "redirect:index";
        }
    }

    //个人中心页面
    @GetMapping("userCenter")
    public String userCenter(HttpSession session){
        String blogText=null;
        List<BlogVo> blogVos=new ArrayList<>();
        User user= (User) session.getAttribute("user");
        List<Board> boardList = boardService.searchBoard(user.getUsername());
        for (Board board : boardList) {
            Blog blog=blogService.findBlog(board.getBlogid());
            BlogVo blogVo=new BlogVo();
//            if(user.getUsername().equals((blogService.findBlog(board.getBlogid())).getUsername())){
//                blogText=blog.getText();
//                blogVo.setText(blogText);
//            }

            blogVo.setTheme(blog.getTheme());
            blogVo.setUsername(blog.getUsername());
            blogVo.setMsg(board.getMsg());
            blogVo.setReplytime(board.getBoardtime());
            blogVos.add(blogVo);
        }
        System.out.println(blogVos);
        List<Blog> searchBlogList = blogService.searchBlog(user.getUsername());
        session.setAttribute("searchBlogList",searchBlogList);
        session.setAttribute("blogVos",blogVos);
        return "userCenter";
    }


}
