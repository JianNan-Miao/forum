package com.cheer.dao;

import com.cheer.domain.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

     void insertBlog(Blog blog);

     List<Blog> getBlog();

     Blog findBlog(Integer blogid);

     void updateBlog(Blog blog);

     List<Blog> searchBlog(String username);

     void delBlog(Integer blogid);

     List<Blog> likeQueryBlog(@Param("theme") String theme);


}
