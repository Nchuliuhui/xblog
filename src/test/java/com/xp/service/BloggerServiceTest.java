package com.xp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by xp on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BloggerServiceTest {

    @Autowired
    private BloggerService bloggerService;


    @Test
    public void getBloggerData() throws Exception {
        System.out.println(bloggerService.getBloggerData());
    }

    @Test
    public void getBloggerByName() throws Exception {
        System.out.println(bloggerService.getBloggerByName("xp"));
    }

    @Test
    public void updateBlogger() throws Exception {
    }

}