package com.tcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @作者:Tcy
 * @date:2020/5/21
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }


    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }
}
