package com.xp.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

/**
 * Created by xp on 2017/7/24.
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
public class DataSourceConfig {

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driver}")
    private String driverName;

    @Value("${jdbc.maxActive}")
    private Integer maxActive;

    @Value("${jdbc.maxIdel}")
    private Integer maxIdel;

    @Value("${jdbc.maxWait}")
    private Integer maxWait;

    @Value("${druid.filters}")
    private String filters;

    @Value("${druid.connectionProperties}")
    private String connectionProperties;


    @Primary
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setMaxActive(maxActive);
        //dataSource.setMaxIdle(maxIdel);
        dataSource.setMaxWait(maxWait);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties(connectionProperties);
        return dataSource;
    }

}
