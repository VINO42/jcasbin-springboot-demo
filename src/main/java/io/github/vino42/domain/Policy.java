package io.github.vino42.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 0:25
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Decription :    Policy 对象封装
 * =====================================================================================
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    /**
     * 模型id
     */
    private String modelId;
    /**
     * 想
     */
    private String unit;
    /**
     * 想要访问资源的用户 或者角色
     */
    private String user;
    /**
     * 将要访问的资源，可以使用  * 作为通配符，例如/user/*
     */
    private String obj;
    /**
     * 用户对资源执行的操作。HTTP方法，GET、POST、PUT、DELETE等，可以使用 * 作为通配符
     */
    private String act;

}
