package com.example.datesources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.datesources.mapper.test3", sqlSessionFactoryRef = "test3SqlSessionFactory")
public class DateSource3Config {
        @Bean(name = "test3DataSource")
        @ConfigurationProperties(prefix = "spring.datasource.test3")
        public DataSource test3DataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean(name = "test3SqlSessionFactory")
        public SqlSessionFactory test3SqlSessionFactory(@Qualifier("test3DataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            return bean.getObject();
        }

        @Bean(name = "test3TransactionManager")
        public DataSourceTransactionManager test3TransactionManager(@Qualifier("test3DataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean(name = "test3SqlSessionTemplate")
        public SqlSessionTemplate test3SqlSessionTemplate(@Qualifier("test3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

