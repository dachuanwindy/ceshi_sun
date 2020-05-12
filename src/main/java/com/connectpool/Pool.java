package com.connectpool;

import redis.clients.jedis.Jedis;

public interface Pool {

    /**
     * @Description: //TODO 初始化对象
     * @Author: sunfch
     * @Date: 2018/12/28 22:43
     * @Param:
     * @Return:
     */
    void init(int maxative, long waittime);

    /**
     * @Description: //TODO 获取连接，
     * @Author: sunfch
     * @Date: 2018/12/28 22:44
     * @Param:
     * @Return:
     */
    Jedis borrowResource() throws Exception;

    /**
     * @Description: //TODO 释放连接，
     * @Author: sunfch
     * @Date: 2018/12/28 22:45
     * @Param:
     * @Return:
     */
    void release(Jedis jedis) throws Exception;


    /**
     * @Description: //TODO 关闭连接
     * @Author: sunfch
     * @Date: 2018/12/28 22:45
     * @Param:
     * @Return:
     */
    void close();
}
