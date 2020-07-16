package com.spring.ioc;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/8 10:57
 */
public class UserController {

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;


}
