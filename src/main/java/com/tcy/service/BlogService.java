package com.tcy.service;

import com.tcy.pojo.Blog;
import com.tcy.pojo.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */
public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
