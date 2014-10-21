/*
 * 
 */
// Created on 2013-8-14

package com.aoyetech.fee.biz.toolutils.core.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author joe.chen
 */
public class DefaultJedisManager extends DefaultRedisManager implements JedisManager {

    private ShardedJedisPool pool;

    private RedisCluster     cluster;

    private int              maxActive;

    private int              maxIdle;

    private long             maxWait;

    private boolean          testOnBorrow;

    private boolean          testOnReturn;

    private boolean          signal = false;

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public void setCluster(RedisCluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public void init() {
        if (cluster != null) {

            List<RedisServer> serverList = cluster.getServerList();

            if (serverList != null && !serverList.isEmpty()) {// 判断集群下是否有server
                List<JedisShardInfo> shardList = new ArrayList<JedisShardInfo>(serverList.size());

                for (RedisServer server : serverList) {
                    JedisShardInfo shard = new JedisShardInfo(server.getHost(), server.getPort());
                    shardList.add(shard);
                }

                // TODO JedisPoolConfig里面的参数可以通过jvm -D参数传入，后期有时间可以扩展
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxActive(maxActive);
                config.setMaxWait(maxWait);
                config.setMaxIdle(maxIdle);
                config.setTestOnBorrow(testOnBorrow);
                config.setTestOnReturn(testOnReturn);
                this.pool = new ShardedJedisPool(config, shardList);

            } else {
                LOGGER.error("redis config server is empty");
            }
        }
    }

    @Override
    public void destory() {
        this.pool.destroy();
    }

    @Override
    public ShardedJedisPool getShardedJedisPool() {
        if (!signal) {
            int waitTimes = 0;
            while (true) {
                if (signal || waitTimes > 1000) {
                    break;
                }
                waitTimes++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    LOGGER.error(e.toString(), e);
                }
            }
        }
        return this.pool;
    }

    public boolean repleaseClient(ShardedJedis jedis) {
        try {
            this.pool.returnResource(jedis);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public void destoryPool() {
        try {
            this.pool.destroy();
        } catch (Exception e) {}
    }

    @Override
    public ShardedJedis getShardedJedis() {
        return getShardedJedisPool().getResource();
    }

    @Override
    public ShardedJedis getShardedJedisBySelect(int dbIndx) {
        ShardedJedis jedis = getShardedJedis();
        Collection<Jedis> js = jedis.getAllShards();
        Iterator<Jedis> it = js.iterator();
        while (it.hasNext()) {
            Jedis j = it.next();
            j.select(dbIndx);
        }
        return jedis;
    }

}
