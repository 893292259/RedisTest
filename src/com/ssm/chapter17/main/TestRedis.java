package com.ssm.chapter17.main;

import redis.clients.jedis.Jedis;

/**
 * Created by zz_liu on 2018/1/18.
 */
public class TestRedis
{
    public static void main(String...args){
        Jedis jedis= new Jedis("localhost",6379);
        int i=0;
        try{
            long start = System.currentTimeMillis();
            while (true){
                long end = System.currentTimeMillis();
                if ((end-start)>=1000){
                    break;
                }
                i++;
                jedis.set("test"+i,i+"");
            }
        }
        finally {
            jedis.close();
        }
        System.out.println("redis每秒操作： "+i+"次");
    }
}
