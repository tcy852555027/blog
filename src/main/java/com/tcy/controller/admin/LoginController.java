package com.tcy.controller.admin;

import com.tcy.pojo.User;
import com.tcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登陆页面
     *
     * @return
     */
    @RequestMapping
    public String toLogin() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, RedirectAttributes attributes) {

        User user = userService.checkUser(username, password);
        if (user != null) {
            // 如果存在用户  讲用户信息放在session
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            // 需要经过redirect  不然会有错
            attributes.addFlashAttribute("message", "用户名密码错误"); //放值在前端
            //model 的话 是拿不到的 因为是重定向
            return "redirect:/admin";
        }

    }

    //注销用户
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
