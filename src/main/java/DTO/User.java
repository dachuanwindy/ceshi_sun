package DTO;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/26 19:12
 */

public class User {

    public String getName(String name) {

        ThreadLocal local = new ThreadLocal();
        local.set("");
        local.remove();
        local.get();
        return "sunfengchuan" + name;
    }
}
