package com.tcy.service.impl;

import com.tcy.dao.UserDao;
import com.tcy.pojo.User;
import com.tcy.service.UserService;
import com.tcy.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User checkUser(String username, String password) {
         User user=  userDao.findByUsernameAndPassword( username, MD5Utils.code(password)) ;

        return user;
    }
}
