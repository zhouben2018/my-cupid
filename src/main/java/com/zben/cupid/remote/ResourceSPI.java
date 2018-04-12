package com.zben.cupid.remote;

import com.zben.cupid.shield.model.UserVo; /**
 * @Author: zben
 * @Description:
 * @Date: 上午9:24 2018/4/12
 */
public interface ResourceSPI {
    Boolean isSaler(UserVo userVo);
}
