package com.zben.cupid.clue.process;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zben.cupid.clue.api.SourceTextService;
import com.zben.cupid.clue.model.Categorys;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.model.ClueMessageData;
import com.zben.cupid.domain.CarMessageView;
import com.zben.cupid.service.BaseMessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:18 2018/4/4
 */
@Service
public class BuyCarClueProcessor extends AbstractClueProcessor {

    private static final String FOLLOW_KEY = "意向车辆: ";
    @Autowired
    private SourceTextService sourceTextService;

    @Autowired
    private BaseMessageService baseMessageService;

    @Transactional("pkgouTransactionManager")
    protected boolean pushMessage(ClueBase clue) {
        ClueMessageData clueMessageData = clue.getData();
        if (clueMessageData == null) {
            return false;
        }
        String storeId = clue.getStoreId(); // 门店
        String platform = clue.getPlatform();   //一级来源
        String clueCategory = clue.getClueCategory();   //二级来源
        String platform3 = clueMessageData.getPlatform3();  //三级来源

        String source = assembleSource(platform, clueCategory, platform3);

        CarMessageView carMessageBody = CarMessageView.builder().platform(platform)
                .clueType(clue.getClueCategory()).followMark(getFollowRemark(clueMessageData))
                .build();
        carMessageBody.setSource(source);
        carMessageBody.setExtType("8036");
        carMessageBody.setStoreId(storeId);

        String isNewCar = "0";
        String isLeaseCar = "0";
        String msgId = baseMessageService.saveAndDetail(carMessageBody, clue, isNewCar, isLeaseCar);

        return false;
    }

    /**
     * 车辆信息  设置展示文案
     * @param clueMessageData
     * @return
     */
    private String getFollowRemark(ClueMessageData clueMessageData) {
        String topModelName = "".equals(clueMessageData.getTp_car_model_name()) ? clueMessageData.getTp_car_model_name() : "";
        String description = clueMessageData.getDescription();
        if (StringUtils.isNotEmpty(clueMessageData.getSc_car_id())) {
            return description;
        }
        description = StringUtils.isEmpty(description) ? "" : description + System.lineSeparator();
        if (StringUtils.isNotEmpty(topModelName)) {
            topModelName = FOLLOW_KEY + topModelName;
            return description + topModelName;
        }

        //先获取model数据, 取第一个
        List<String> models = clueMessageData.getModels();
        if (CollectionUtils.isNotEmpty(models)) {
            topModelName = FOLLOW_KEY + models.get(0);
        }
        return description + topModelName;
    }

    /**
     * 拼接
     * @param platform
     * @param clueCategory
     * @param platform3
     * @return
     */
    private String assembleSource(String platform, String clueCategory, String platform3) {
        StringBuffer sb = new StringBuffer();
        Categorys categorys = null;
        if (platform != null) {
            categorys = sourceTextService.getByCode(platform);
            if (categorys != null) {
                sb.append(categorys.getName());
            }
        }
        if (clueCategory != null) {
            categorys = sourceTextService.getByCode(clueCategory);
            if (categorys != null) {
                sb.append("-").append(categorys.getName());
            }
        }
        if (platform3 != null) {
            categorys = sourceTextService.getByCode(platform3);
            if (categorys != null) {
                sb.append("-").append(categorys.getName());
            }
        }
        if (sb != null && sb.toString().startsWith("-")) {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}



































