package com.xp.service.impl;

import com.xp.dao.BloggerDao;
import com.xp.model.Blogger;
import com.xp.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xp on 2017/8/5.
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerDao bloggerDao;

    @Override
    public Blogger getBloggerData() {
        return bloggerDao.getBloggerData();
    }

    @Override
    public Blogger getBloggerByName(String username) {
        return bloggerDao.getBloggerByName(username);
    }

    @Override
    public Integer updateBlogger(Blogger blogger) {
        return bloggerDao.updateBlogger(blogger);
    }
}
