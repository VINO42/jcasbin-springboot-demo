package io.github.vino42;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@MapperScan("io.github.vino42.domain.mapper")
@ServletComponentScan(basePackages = "io.github.vino42")
@EnableTransactionManagement
@SpringBootApplication
public class JcasbinSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcasbinSpringbootDemoApplication.class, args);
    }

}
