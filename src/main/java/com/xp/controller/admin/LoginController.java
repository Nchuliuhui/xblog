package com.xp.controller.admin;

import com.xp.model.Blogger;
import com.xp.service.BloggerService;
import com.xp.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xp on 2017/8/5.
 */
@Controller
@Api(description = "博主登录")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BloggerService bloggerService;

    @GetMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @ApiOperation(value = "登录接口", notes = "根据用户名登录")
    @PostMapping(value = "/login")
    public String login(@ApiParam(value = "用户名不能为空 否则登录失败", required = true)
                         @RequestParam(value = "username", required = false) String username,
                        @ApiParam(value = "密码为长度32的hash字符不能为空 否则登录失败", required = true)
                         @RequestParam(value = "password", required = false) String password,
                        Model model) {
        String url = null;
        //获取登录实体
        Subject subject = SecurityUtils.getSubject();
        //密码加密
        password = MD5Util.md5(password,MD5Util.SALT);
        //创建username password类型登录token
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            //根据token登录 会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
            subject.login(token);
            model.addAttribute("name","YuKong");
            url = "admin/index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            url =  "login";
        } finally {
            return url;
        }
    }

}
