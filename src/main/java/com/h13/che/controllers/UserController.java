package com.h13.che.controllers;

import com.h13.che.core.*;
import com.h13.che.services.UserService;
import com.h13.che.vos.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-19
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("password");
            UserVO userVO = userService.login(mobile, password);

            return H13ResponseWrapper.success(CheConstants.DEFAULT_UID,
                    H13Data.getData().add("user", userVO));
//        } catch (H13RequestErrorException he) {
//            return H13ResponseWrapper.failure(he.getCode(), CheConstants.DEFAULT_UID,
//                    H13Data.getData());
        } catch(Exception e){
            return H13ResponseWrapper.failure( CheConstants.DEFAULT_UID,
                    H13Data.getData());
        }
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response){
        try {
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("password");
            UserVO userVO = userService.register(mobile, password);

            return H13ResponseWrapper.success(CheConstants.DEFAULT_UID,
                    H13Data.getData().add("user", userVO));
//        } catch (H13RequestErrorException he) {
//            return H13ResponseWrapper.failure(he.getCode(), CheConstants.DEFAULT_UID,
//                    H13Data.getData());
        } catch(Exception e){
            return H13ResponseWrapper.failure( CheConstants.DEFAULT_UID,
                    H13Data.getData());
        }
    }




}
