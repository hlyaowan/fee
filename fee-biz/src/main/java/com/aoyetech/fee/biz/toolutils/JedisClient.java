package com.aoyetech.fee.biz.toolutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

import com.aoyetech.fee.biz.toolutils.core.redis.JedisManager;

//@Component
public class JedisClient {

    private static final Logger LOGGER      = LoggerFactory.getLogger(JedisClient.class);

    // @Autowired
    private JedisManager        redisManager;

    private int                 modelInfoDb = 3;

    public JedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(JedisManager redisManager) {
        this.redisManager = redisManager;
    }

    public int getModelInfoDb() {
        return modelInfoDb;
    }

    public void setModelInfoDb(int modelInfoDb) {
        this.modelInfoDb = modelInfoDb;
    }

    /**
     * Redis db: 0:ip data 1: adaptive data 2:company_model data 3-4:model_info data
     */

    public Jedis getIPClient(ShardedJedis client, String ip) {
        try {
            // ShardedJedis client = redisManager.getShardedJedisBySelect(0);
            Jedis j = client.getShard(ip);
            j.select(0);
            return j;
        } catch (Exception e) {
            LOGGER.error("select IP client error." + e.toString());
        }
        return null;
    }

    public Jedis getModelInfoClient(ShardedJedis client, String modelinfo) {
        try {
            // ShardedJedis client = redisManager.getShardedJedisBySelect(model_info_db);
            // ShardedJedis client = redisManager.getShardedJedis();
            Jedis j = client.getShard(modelinfo);
            j.select(3);
            return j;
        } catch (Exception e) {
            LOGGER.error("select ModelInfo client error." + e.toString());
            
        }
        return null;
    }

    public Jedis getAdaptiveClient(ShardedJedis client, String adaptive) {
        try {
            // ShardedJedis client = redisManager.getShardedJedisBySelect(1);//TODO 测试代码
            // ShardedJedis client = redisManager.getShardedJedis();
            Jedis j = client.getShard(adaptive);
            j.select(1);
            return j;
        } catch (Exception e) {
            LOGGER.error("select Adaptive client error." + e.toString());
            return null;
        }
    }

    public Jedis getCompanyModelClient(ShardedJedis client, String companyModel) {
        try {
            // ShardedJedis client = redisManager.getShardedJedis();
            // ShardedJedis client = redisManager.getShardedJedisBySelect(2);
            Jedis j = client.getShard(companyModel);
            j.select(2);
            return j;
        } catch (Exception e) {
            LOGGER.error("select CompanyModel client error." + e.toString());
            return null;
        }
    }

    public Jedis getJedisClient(ShardedJedis client, String key, int storeNum) {
        try {
            Jedis j = client.getShard(key);
            j.select(storeNum);
            return j;
        } catch (Exception e) {
            LOGGER.error("select CompanyModel client error." + e.toString());
            return null;
        }
    }

    public ShardedJedis getShardedJedis() {
        return redisManager.getShardedJedis();
    }

    public void repleaseClient(ShardedJedis client) {
        redisManager.repleaseClient(client);
    }
}
