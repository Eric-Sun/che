package com.h13.che.services;

import com.h13.che.cache.co.MessageCO;
import com.h13.che.cache.service.MessageCache;
import com.h13.che.daos.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午1:55
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageService {

    @Autowired
    MessageDAO messageDAO;

    @Autowired
    MessageCache messageCache;

    public void send(String uid, String content) {
        long mid = messageDAO.add(uid, content);
        MessageCO messageCO = new MessageCO();
        messageCO.setId(mid);
        messageCO.setContent(content);
        messageCO.setUid(uid);
        messageCO.setTs(System.currentTimeMillis());
        messageCache.put(messageCO);
    }

    public MessageCO get(String uid) {
        MessageCO co = messageCache.get(uid);
        return co;
    }
}

