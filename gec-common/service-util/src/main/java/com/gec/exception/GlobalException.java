package com.gec.exception;


import com.gec.system.util.Result;
import com.gec.system.util.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalException {

    //1.全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e)
    {
        System.out.println("全局执行....");;
        e.printStackTrace();
        return Result.fail().message(e.getMessage());
    }

    //2.特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e)
    {
        System.out.println("特定执行.");
        e.printStackTrace();
        return Result.fail().message("算术异常..");
    }

    /**
     * spring security异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result error(AccessDeniedException e) throws AccessDeniedException {
        return Result.fail().code(ResultCodeEnum.PERMISSION.getCode()).message("没有当前操作权限");
    }

    @ExceptionHandler(MyCustomerException.class)
    @ResponseBody
    public Result error(MyCustomerException e)
    {
        log.error("MyCustomerException："+e.getMessage(), e);
        return Result.fail().code(e.getCode()).message(e.getMsg()).message(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result error(RuntimeException e)
    {
        log.error("RuntimeException："+e.getMessage(), e);
        return Result.fail().message(e.getMessage());
    }
}