package com.h13.che.controllers;

import com.h13.che.cache.co.CommentCO;
import com.h13.che.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/send")
    public String send(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String content = request.getParameter("content");
        long mid = new Long(request.getParameter("mid"));

        commentService.add(uid, mid, content);

//        return DTOUtils.getOriginalResponse(request, response, uid, Constants.DEFAULT_TO_SESSION_ID);
        return null;
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        long mid = new Long(request.getParameter("mid"));
        List<CommentCO> list = commentService.get(uid, mid);
//        return DTOUtils.getSucessResponse(request, response, uid, Constants.DEFAULT_TO_SESSION_ID, list);
        return null;
    }



}
