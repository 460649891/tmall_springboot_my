package com.how2j.tmall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @title title
 * @date 2018/11/30
 * @description: TODO(用一句话描述该文件做什么)
 */
@RestController
@ControllerAdvice
public class GloabalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if (null != e.getCause() && constraintViolationException == e.getCause().getClass()) {
            return "违反了约束，多半是外键约束";
        }
        return e.getMessage();
    }

}