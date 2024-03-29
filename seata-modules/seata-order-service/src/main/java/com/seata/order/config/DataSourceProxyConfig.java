package com.seata.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Date 2023/2/18 23:18
 * @Description 使用seata对数据源代理
 * @since version-1.0
 */
@Configuration
public class DataSourceProxyConfig {
	@Value("${mybatis.mapperLocations}")
	private String mapperLocations;

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.master")
	public DataSource druidDataSource(){
		return new DruidDataSource();
	}

	@Bean
	public DataSourceProxy dataSourceProxy(DataSource dataSource){
		return new DataSourceProxy(dataSource);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSourceProxy) throws Exception{
		MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSourceProxy);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
		return sqlSessionFactoryBean.getObject();
	}
}