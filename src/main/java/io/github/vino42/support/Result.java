package io.github.vino42.support;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import static io.github.vino42.support.Constant.Response.*;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:59
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription : 响应类
 * =====================================================================================
 */
@Data
public class Result<T> implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(Result.class);
    private static final long serialVersionUID = -1893521199702700771L;

    private int status;
    private String message;
    private T data;


    public Result(int status, String message, T result) {

        super();
        this.status = status;
        this.message = message;
        this.data = result;
    }

    public Result(int status, String message) {

        this(status, message, null);
    }

    public static <E> Result ok(E o) {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, o);
    }

    public static <E> Result ok() {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, StrUtil.EMPTY);
    }

    public static <E> Result<E> illegalArgument() {

        return wrap(ILLEGAL_ARGUMENT_ERROR_CODE, ILLEGAL_ARGUMENT_ERROR_MSG);
    }

    public static <E> Result<E> noPermission() {

        return wrap(NEED_AUT_ERROR_CODE, NEED_AUT_ERROR_MSG);
    }
    public static <E> Result<E> wrap(int status, String message) {

        return wrap(status, message, null);
    }

    public static <E> Result<E> wrap(int status, String message, E o) {

        return new Result<>(status, message, o);
    }
}
