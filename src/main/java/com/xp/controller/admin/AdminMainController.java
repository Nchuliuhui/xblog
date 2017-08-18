package com.xp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xp on 2017/8/18.
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminMainController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public  String toMainPage(){
        return "/admin/index";
    }

}
