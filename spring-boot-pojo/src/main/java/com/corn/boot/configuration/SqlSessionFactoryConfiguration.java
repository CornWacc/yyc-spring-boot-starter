package com.corn.boot.configuration;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * @author yyc
 * @apiNote 自动注入myabatis mapping
 *
 * 1.解决了自动生成(generator)的时候找不到mapping的问题
 * */
@Configuration
@PropertySource(value = "classpath:application-dev.properties")
public class SqlSessionFactoryConfiguration {

    private static final Logger log = LoggerFactory.getLogger(SqlSessionFactoryBean.class);

    @Value("${mapping.path}")
    private String mappingPath;


    /**
     * SqlSessionFactory创建需要原数据源
     * */
    @Autowired
    private DataSource dataSource;

    @Bean(name = "SqlSessionFactoryBean")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        System.out.println("mapping路径 :"+mappingPath);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String mapping = resolver.CLASSPATH_ALL_URL_PREFIX+mappingPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapping));
        sqlSessionFactoryBean.setDataSource(dataSource);
        log.info("SqlSessionFactoryBean 注入成功");
        return sqlSessionFactoryBean;
    }
}
