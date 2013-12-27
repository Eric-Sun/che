package com.h13.che.cache.service;

import com.h13.che.cache.co.CommentCO;
import com.h13.che.cache.co.MessageCO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentCache {
    private static String PREFIX = "che:cmt:";

    @Resource(name = "commentCOTemplate")
    private RedisTemplate<String, CommentCO> commentCOTemplate;

    public void put(CommentCO messageCO) {
        String key = PREFIX + messageCO.getMid();
        commentCOTemplate.opsForList().leftPush(key, messageCO);
    }

    public List<CommentCO> get(long mid) {
        String key = PREFIX + mid;
        long size = commentCOTemplate.opsForList().size(key);
        if(size==0)
            return null;
        return commentCOTemplate.opsForList().range(key,0,size);
    }

    public void putAll(long mid,List<CommentCO> list){
        String key =  PREFIX + mid;
        for(CommentCO cmt : list){
            commentCOTemplate.opsForList().leftPush(key,cmt);
        }
    }
}
