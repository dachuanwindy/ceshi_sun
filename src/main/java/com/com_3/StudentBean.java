package com.com_3;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2019/9/2 00:14
 */
@Data
public class StudentBean {

    StudentBean2 studentBean2;

    public String message(String name) {
        return "spring beans system out msg" + name;
    }

    StudentBean(){}
}
