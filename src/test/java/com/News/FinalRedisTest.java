package com.News;

import redis.clients.jedis.Jedis;

import redis.clients.jedis.Jedis;

public class FinalRedisTest {
    public static void main(String[] args) {
        System.out.println("开始连接 Redis...");

        try {
            // 1. 创建连接
            Jedis jedis = new Jedis("192.168.27.136", 6379);

            // 2. 设置连接超时（可选）
            jedis.connect();

            // 3. 认证
            jedis.auth("123456");

            // 4. 测试连接
            String pingResult = jedis.ping();
            System.out.println("Ping 结果: " + pingResult);

            // 5. 写入数据
            String key = "user:" + System.currentTimeMillis();
            String value = "测试数据_" + System.currentTimeMillis();
            jedis.set(key, value);
            System.out.println("写入数据: key=" + key + ", value=" + value);

            // 6. 读取数据
            String readValue = jedis.get(key);
            System.out.println("读取数据: " + readValue);

            // 7. 验证数据一致性
            if (value.equals(readValue)) {
                System.out.println("✅ 数据验证成功！");
            } else {
                System.out.println("❌ 数据不一致");
            }

            // 8. 关闭连接
            jedis.close();
            System.out.println("连接已关闭");

        } catch (Exception e) {
            System.out.println("错误信息: " + e.getMessage());
            e.printStackTrace();
        }
    }
}