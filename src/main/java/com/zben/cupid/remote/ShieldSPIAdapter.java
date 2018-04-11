package com.zben.cupid.remote;

import com.zben.cupid.shield.api.UserService;
import com.zben.cupid.shield.model.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:41 2018/4/11
 */
@Service
@Slf4j
public class ShieldSPIAdapter implements ShieldSPI {

    @Autowired
    private UserService userService;

    @Override
    public String getAccountById(String userId) {
        UserVo userVo = getUserById(userId);
        String account = null;
        if (userVo == null) {
            return null;
        } else {
            account = userVo.getAccount();
        }
        return StringUtils.isBlank(account) ? null : account;
    }

    private UserVo getUserById(String userId) {
        UserVo userVo = null;
        try {
            if (StringUtils.isBlank(userId)) {
                return null;
            }
            userVo = userService.get(userId);
        } catch (Exception e) {
            log.error("getUserById....", e);
            e.printStackTrace();
        }
        return userVo;
    }
}


























