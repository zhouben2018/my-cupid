package com.zben.cupid.remote;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zben.cupid.clue.model.AppPrivilege;
import com.zben.cupid.shield.api.ResourceService;
import com.zben.cupid.shield.model.ResourceVo;
import com.zben.cupid.shield.model.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午9:25 2018/4/12
 */
@Service
@Slf4j
public class ResourceSPIAdapter implements ResourceSPI {

    @Autowired
    private ResourceService resourceService;

    @Override
    public Boolean isSaler(UserVo userVo) {
        if (userVo == null) {
            return false;
        }
        List<String> resCodes = extractResourceCode(resourceService.getResourceByUserId(userVo.getId()));
        if (resCodes == null) {
            return false;
        }
        return resCodes.contains(AppPrivilege.AppPrivilegeEnum.SHIELD_SALES.getCode());
    }

    private List<String> extractResourceCode(List<ResourceVo> resources) {
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(resources)) {
            return result;
        }
        for (ResourceVo resourceVo : resources) {
            result.add(resourceVo.getCode());
        }
        return result;
    }
}









































