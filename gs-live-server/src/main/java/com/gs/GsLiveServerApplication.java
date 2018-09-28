package com.gs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement  // 开启事务注解
@MapperScan("com.gs.subproject.*.dao")   // 扫描mapper接口
public class GsLiveServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsLiveServerApplication.class, args);
    }
}
