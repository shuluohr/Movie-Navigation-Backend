package com.gec.exception;

import com.gec.system.util.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCustomerException extends RuntimeException {
    private Integer code;
    private String msg;

    //3.执行自定义异常
    @ExceptionHandler(MyCustomerException.class)
    @ResponseBody
    public Result error(MyCustomerException e)
    {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

}