package com.xp.controller.admin;

import com.xp.dto.Result;
import com.xp.model.Blogger;
import com.xp.service.BloggerService;
import com.xp.util.AliOSSUtil;
import com.xp.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Author xp
 * @Description 头像上传
 * @Date 2017/8/6 17:23
 */
@RequestMapping(value = "/file")
@Controller
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private BloggerService bloggerService;

    //文件上传相关代码
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return ResultUtil.error(500,"文件为空，上传失败");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
       // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //logger.info("上传的后缀名为：" + suffixName);
        // 解决中文问题，liunx下中文路径，图片显示问题
        File dest = new File(fileName);
        try {
           // file.transferTo(dest);
            String url = AliOSSUtil.upload(file.getInputStream());
            Blogger blogger = (Blogger) request.getSession().getAttribute("currentUser");
            blogger.setImagename(url);
            bloggerService.updateBlogger(blogger);
            logger.info("修改头像成功" + url);
            return ResultUtil.success("上传成功!",url);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtil.error(500,"服务器错误，上传失败");
    }

}
