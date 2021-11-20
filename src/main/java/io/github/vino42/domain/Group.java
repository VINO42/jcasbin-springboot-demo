package io.github.vino42.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 0:26
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Decription :  组对象封装
 * =====================================================================================
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    /**
     * 请求对象
     */
    private String rSub;

    /**
     * 策略对象
     */
    private String pSub;
}
