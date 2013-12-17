package com.h13.che.cache.service;

import com.h13.che.cache.co.MessageCO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class MessageCache {
    private static String PREFIX = "che:msg:";

    @Resource(name = "messageCOTemplate")
    private RedisTemplate<String, MessageCO> messageCOTemplate;

    public void put(MessageCO messageCO) {
        String key = PREFIX + messageCO.getUid();
        messageCOTemplate.opsForValue().set(key, messageCO);
    }

    public MessageCO get(String id) {
        String key = PREFIX + id;
        return messageCOTemplate.opsForValue().get(key);
    }

}
