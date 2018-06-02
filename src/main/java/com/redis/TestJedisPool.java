package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedisPool {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(30);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        JedisPool jedisPool = new JedisPool(config,
                "192.168.84.139", 6379);

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();

            jedis.set("name", "zhangsan");

            String name = jedis.get("name");
            System.out.println(name);

        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if (jedis!=null){
                jedis.close();
            }

            if (jedisPool != null){
                jedisPool.close();
            }
        }
    }
}
