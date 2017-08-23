package com.xp.controller.admin;

import com.xp.dto.Result;
import com.xp.model.Blogger;
import com.xp.service.BloggerService;
import com.xp.util.MD5Util;
import com.xp.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xp on 2017/8/18.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminBloggerController {

    @Autowired
    private BloggerService bloggerService;

    /**
     * 更新密码
     * @param oldPassword
     * @param newPassword
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/password" , method = RequestMethod.POST)
    public Result modifyPassword(String oldPassword , String newPassword, HttpServletRequest request){
        Blogger blogger = (Blogger) request.getSession().getAttribute("currentUser");
        if(!blogger.getPassword().equals(MD5Util.md5(oldPassword,MD5Util.SALT))){
            return ResultUtil.error(500,"旧密码错误！");
        }
        blogger.setPassword(MD5Util.md5(oldPassword,MD5Util.SALT));
        bloggerService.updateBlogger(blogger);
        return ResultUtil.success("修改密码成功！");
    }
}
