package com.corn.boot.configuration;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.sql.SQLException;


@Configuration
//@EnableConfigurationProperties({DataSourceProperties.class})
@AutoConfigureAfter(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DataSourceAutoConfiguration.class);

    @Value("${mapping.path}")
    private String mappingPath;

    @Autowired
    private DruidDataSource dataSource;

    @Bean
    public SqlSessionFactoryBean createSqlSessiongFactoryBean(){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            if(!ObjectUtils.isEmpty(dataSource.getConnection())){
                sqlSessionFactoryBean.setDataSource(dataSource);
                PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

                //获取所有mybatis的mapper.xml映射
                sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mappingPath));
            }
        } catch (SQLException e) {
            log.info("数据库连接失败！！,原因:{}",e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }

    public String getMappingPath() {
        return mappingPath;
    }

    public void setMappingPath(String mappingPath) {
        this.mappingPath = mappingPath;
    }
}

