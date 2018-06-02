package com.redis;

import redis.clients.jedis.Jedis;

public class TestJedisSingle {
    public static void main(String[] args) {
        Jedis jedis =new Jedis("192.168.84.139",6379);
        jedis.set("name","zhangsna");
        String name=jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}
