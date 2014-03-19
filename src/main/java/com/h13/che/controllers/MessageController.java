package com.h13.che.controllers;

import com.h13.che.cache.co.MessageCO;
import com.h13.che.core.CheConstants;
import com.h13.che.core.H13Data;
import com.h13.che.core.H13ResponseWrapper;
import com.h13.che.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @ResponseBody
    public String send(HttpServletRequest request, HttpServletResponse response) {
        try {
            String uid = request.getParameter("uid");
            String content = request.getParameter("content");
            long mid = messageService.send(uid, content);
            return H13ResponseWrapper.failure(CheConstants.DEFAULT_UID,
                    H13Data.getData().add("mid", mid));
        } catch (Exception e) {
            return H13ResponseWrapper.failure(CheConstants.DEFAULT_UID,
                    H13Data.getData());
        }
    }

    @RequestMapping("/fetchAll")
    @ResponseBody
    public String fetchAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            int pageNum = 1;
            if (request.getParameter("pageNum") != null)
                pageNum = new Integer(request.getParameter("pageNum"));
            List<MessageCO> list = messageService.fetchAll(pageNum, 10);
            return H13ResponseWrapper.failure(CheConstants.DEFAULT_UID,
                    H13Data.getData().add("list", list));
        } catch (Exception e) {
            return H13ResponseWrapper.failure(CheConstants.DEFAULT_UID,
                    H13Data.getData());
        }
    }


}
