package io.github.vino42.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/19 22:21
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "ok";


    }

    @RequestMapping("/ask")
    public String ask() {

        return "ok";

    }

    @RequestMapping("/go")
    public String go() {

        return "ok";

    }

    @RequestMapping("/live")
    public String live() {

        return "live";

    }

    @RequestMapping("/love")
    public String love() {

        return "love";

    }

    @RequestMapping("/laugh")
    public String laugh() {

        return "laugh";

    }
}
