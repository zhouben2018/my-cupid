package com.zben.cupid.clue.process;

import com.zben.cupid.clue.api.SourceTextService;
import com.zben.cupid.clue.model.Categorys;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.model.ClueMessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:18 2018/4/4
 */
@Service
public class BuyCarClueProcessor extends AbstractClueProcessor {

    @Autowired
    private SourceTextService sourceTextService;

    protected boolean pushMessage(ClueBase clue) {
        ClueMessageData clueMessageData = clue.getData();
        if (clueMessageData == null) {
            return false;
        }
        String platform = clue.getPlatform();   //一级来源
        String clueCategory = clue.getClueCategory();   //二级来源
        String platform3 = clueMessageData.getPlatform3();  //三级来源

        String source = assembleSource(platform, clueCategory, platform3);

        return false;
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
        return sb.toString();
    }

}



































