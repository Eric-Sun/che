package com.h13.che.services;

import com.h13.che.core.log.H13Logger;
import com.h13.che.core.log.H13LoggerEntity;
import com.h13.che.daos.UserDAO;
import com.h13.che.utils.MD5Util;
import com.h13.che.vos.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-19
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public UserVO login(String mobile, String password) {
        String passwordAfterMD5 = MD5Util.getMD5String(password);
        long id = userDAO.loginByMobile(mobile, passwordAfterMD5);
        UserVO vo = new UserVO();
        vo.setUid(id);
        return vo;
    }

    public UserVO register(String mobile, String password) {
        String passwordAfterMD5 = MD5Util.getMD5String(password);
        long id = userDAO.register(mobile, passwordAfterMD5);
        UserVO vo = new UserVO();
        vo.setUid(id);
        H13Logger.info(H13LoggerEntity.p("user", "register", -1, ""));
        return vo;
    }


}
