/*
 * 
 */
// Created on 2013-8-15

package com.aoyetech.fee.biz.toolutils.core.redis;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author joe.chen
 */
public interface JedisManager extends RedisManager {

    public ShardedJedisPool getShardedJedisPool();

    public boolean repleaseClient(ShardedJedis jedis);

    public ShardedJedis getShardedJedis();

    public ShardedJedis getShardedJedisBySelect(int dbIndx);

}
