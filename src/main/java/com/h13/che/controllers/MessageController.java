package com.h13.che.controllers;

import com.h13.che.cache.co.MessageCO;
import com.h13.che.config.Constants;
import com.h13.che.services.MessageService;
import com.h13.che.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/send")
    public String send(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String content = request.getParameter("content");

        messageService.send(uid, content);

        return DTOUtils.getOriginalResponse(request, response, uid, Constants.DEFAULT_TO_SESSION_ID);

    }

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        MessageCO message = messageService.get(uid);

        return DTOUtils.getSucessResponse(request, response, uid, Constants.DEFAULT_TO_SESSION_ID, message);

    }

}
