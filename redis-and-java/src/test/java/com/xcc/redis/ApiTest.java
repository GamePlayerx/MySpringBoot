package com.xcc.redis;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/26
 */
public class ApiTest {
    JedisPool jedisPool;

    // 1 首先创建连接
    @BeforeTest
    public void beforeTest() {
        // 创建jedis连接池
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大空闲连接
        config.setMaxIdle(10);
        // 最小空闲连接
        config.setMinIdle(5);
        // 最大空闲时间 这里设置的4秒
        config.setMaxWaitMillis(4000);
        // 最大连接数
        config.setMaxTotal(50);

        // 这里连接的是本地的redis，默认端口号是6379
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    @Test
    public void test() {
        // 从池子中拿一个连接
        Jedis jedis = jedisPool.getResource();
        String name = jedis.get("myname");
        System.out.println("name====="+name);

        // 关掉jedis
        jedis.close();
    }

    // redis string相关的实例：
    @Test
    public void testString() {
        // 从池子中拿一个连接
        Jedis jedis = jedisPool.getResource();

        // 1. 添加一个string类型的数据，key为pv，用于保持pv的值，初始值为0
        String pv = jedis.set("pv", "0");

        // 2. 查询该key对应的数据
        String pv1 = jedis.get("pv");
        System.out.println("pv1=="+pv1);

        // 3. 修改pv为1000
        jedis.set("pv", "1000");
        pv1 = jedis.get("pv");
        System.out.println("pv1=="+pv1);

        // 4. 实现整形数据原子自增操作 +1
        Long pv2 = jedis.incr("pv");
        System.out.println("pv2=="+pv2);

        // 5. 实现整形该数据原子自增操作 + 1000
        Long pv3 = jedis.incrBy("pv", 1000);
        System.out.println("pv3=="+pv3);

        // 关掉jedis
        jedis.close();
    }

    // redis hash相关操作实例
    @Test
    public void testHash() {
        // 从池子中拿一个连接
        Jedis jedis = jedisPool.getResource();

        // 1. 往Hash结构中添加以下商品库存 goods
        // a) xiaomi14Pro -> 10000
        // b） mate60Pro  -> 9000
        jedis.hset("goods", "xiaomi14Pro", "10000");
        jedis.hset("goods", "mate60Pro", "9000");

        // 2. 获取Hash中所有的商品
        Set<String> goods = jedis.hkeys("goods");
        for (String good : goods) {
            System.out.println(good);
        }

        // 3. 新增3000个mate60Pro库存
        // 有两种方法可以实现:
        // 第一种方法,先从redis中拿到mate60Pro的数量，然后将数值修改，再放回去。
        // 逻辑没问题不过一般不这样操作，因为在高并发情况下会出问题
        // String hget = jedis.hget("goods", "mate60Pro");
        // int stock = Integer.parseInt(hget) + 3000;
        // jedis.hset("goods", "mate60Pro", stock+"");

        // 一般是直接用原子操作
        jedis.hincrBy("goods", "mate60Pro", 3000);

        String hget = jedis.hget("goods", "mate60Pro");
        System.out.println("hget=="+hget);

        // 4. 删除整个Hash的数据
        jedis.del("goods");

        // 关掉jedis
        jedis.close();
    }

    // redis list相关操作实例：
    @Test
    public void testList() {
        // 从池子中拿一个连接
        Jedis jedis = jedisPool.getResource();

        // 1. 向list的左边插入以下三个手机号码：18511310002，18912301233，18123123314
        jedis.lpush("phoneNumber", "18511310002", "18912301233", "18123123314");

        // 2. 从右边移除一个手机号码
        String phoneNumber = jedis.rpop("phoneNumber");
        System.out.println("phoneNumber=="+phoneNumber);

        // 3. 获取list所有的值
        List<String> phoneNumber1 = jedis.lrange("phoneNumber", 0, -1);
        for (String s : phoneNumber1) {
            System.out.println(s);
        }

        // 关掉jedis
        jedis.close();
    }

    // redis set相关操作实例：
    @Test
    public void testSet() {
        // 从池子中拿一个连接
        Jedis jedis = jedisPool.getResource();

        // 使用set来保持uv值，为了方便计算，将用户名保存到uv中。
        // 1. 往一个set中提娜佳页面page1的uv，用户user1访问一次该页面
        jedis.sadd("uv", "user1");

        // 2. user2访问一次该页面
        jedis.sadd("uv", "user2");

        // 3. user1再访问一次该页面
        jedis.sadd("uv", "user1");

        // 4. 最后获取 page1的uv值
        Long uv = jedis.scard("uv");
        System.out.println("uv=="+uv);

        // 关掉jedis
        jedis.close();
    }

    // 9 关闭连接
    @AfterTest
    public void closeTest() {
        jedisPool.close();
    }

}
