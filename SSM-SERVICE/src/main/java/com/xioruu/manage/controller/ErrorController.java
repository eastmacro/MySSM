package com.xioruu.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiong
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 没有权限
     * @return
     */
    @RequestMapping("/noPerms")
    public String noPerms(){
        return "/common/error/noPerms";
    }
}
