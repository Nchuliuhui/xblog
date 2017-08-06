package com.xp.config.db;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by xp on 2017/7/12.
 */
@WebFilter(filterName = "druidWebStatFilter",urlPatterns = "/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }

)
public class DruidStatFilter extends WebStatFilter {
}
