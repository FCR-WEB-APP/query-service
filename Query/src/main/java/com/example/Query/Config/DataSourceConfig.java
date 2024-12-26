package com.example.Query.Config;

import com.example.Query.Dao.DataBaseConfig1;
import com.example.Query.Dao.DataBaseConfig2;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    private final DataBaseConfig1 dataBaseConfig1;
    private final DataBaseConfig2 dataBaseConfig2;

    public DataSourceConfig(DataBaseConfig1 dataBaseConfig1, DataBaseConfig2 dataBaseConfig2) {
        this.dataBaseConfig1 = dataBaseConfig1;
        this.dataBaseConfig2 = dataBaseConfig2;
    }



    @Bean(name = "datasource1")
    public HikariDataSource dataSource1(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dataBaseConfig1.getUrl());
        hikariConfig.setUsername(dataBaseConfig1.getUserName());
        hikariConfig.setPassword(dataBaseConfig1.getPassword());
        hikariConfig.setDriverClassName(dataBaseConfig1.getDriverClassName());
        return new HikariDataSource(hikariConfig);
    }
//
//    @Bean(name = "datasource1")
//    public HikariDataSource dataSource1(){
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/fcr_case_dev");
//        hikariConfig.setUsername("root");
//        hikariConfig.setPassword("root");
//        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        return new HikariDataSource(hikariConfig);
//    }


    @Bean(name = "datasource2")
    public HikariDataSource dataSource2() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dataBaseConfig2.getUrl());
        hikariConfig.setUsername(dataBaseConfig2.getUserName());
        hikariConfig.setPassword(dataBaseConfig2.getPassword()); 
        hikariConfig.setDriverClassName(dataBaseConfig2.getDriverClassName());
        return new HikariDataSource(hikariConfig);
    }


//    @Bean(name = "datasource2")
//    public HikariDataSource dataSource2() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/xe");
//        hikariConfig.setUsername("fcr_project");
//        hikariConfig.setPassword("sarasu10");
//        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        return new HikariDataSource(hikariConfig);
//    }

}
