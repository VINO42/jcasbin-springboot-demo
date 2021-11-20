package io.github.vino42;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;


@MapperScan("io.github.vino42")
@ServletComponentScan(basePackages = "io.github.vino42")
@SpringBootApplication
public class JcasbinSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcasbinSpringbootDemoApplication.class, args);
    }

}
