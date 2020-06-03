package com.tcy.dao;

import com.tcy.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */
public interface TagDao  extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
