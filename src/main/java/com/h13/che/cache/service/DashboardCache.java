package com.h13.che.cache.service;

import com.h13.che.cache.co.CommentCO;
import com.h13.che.cache.co.MessageCO;
import com.h13.che.core.CheConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-19
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DashboardCache {

    private static String KEY = "che:db";

    @Resource(name = "dashboardTemplate")
    private RedisTemplate<String, MessageCO> dashboardTemplate;

    public void put(MessageCO messageCO) {
        long size = dashboardTemplate.opsForList().size(KEY);
        if (size == CheConstants.DASHBOARD_CACHE_SIZE) {
            dashboardTemplate.opsForList().rightPop(KEY);
            dashboardTemplate.opsForList().leftPush(KEY, messageCO);
        }
    }

    public List<MessageCO> get() {
        long size = dashboardTemplate.opsForList().size(KEY);
        return dashboardTemplate.opsForList().range(KEY, 0, size);
    }


}
