package com.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yslu
 * @Date: 2019/6/26 9:51
 * @description：
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello spring";
    }
    @RequestMapping("/one")
    public String one() {
        System.out.println("hello");
        return " out one";
    }
}