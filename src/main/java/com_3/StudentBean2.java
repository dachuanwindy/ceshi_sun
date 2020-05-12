package com_3;

import com.google.common.annotations.VisibleForTesting;
import lombok.Data;

import java.util.HashMap;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2019/9/2 00:14
 */
@Data
public class StudentBean2 {

    StudentBean studentBean;

    public String message(String name) {

        HashMap map = new HashMap();
        map.put("aaa", "");
        return "spring beans system out msg" + name;
    }

    @VisibleForTesting
    private void test22() {
        System.out.println("=====");
    }
}
