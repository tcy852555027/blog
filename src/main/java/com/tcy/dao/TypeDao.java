package com.tcy.dao;

import com.tcy.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @作者:Tcy
 * @date:2020/5/26
 */
public interface TypeDao extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
