package com.tcy.dao;

import com.tcy.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */

public interface BlogDao  extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {
}
