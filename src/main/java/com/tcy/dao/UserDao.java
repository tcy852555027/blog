package com.tcy.dao;

import com.tcy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
