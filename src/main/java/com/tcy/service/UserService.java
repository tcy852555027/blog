package com.tcy.service;

import com.tcy.pojo.User;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */
public interface UserService {

    User checkUser(String username, String password);
}
