package com.zben.cupid.commons;

import java.util.UUID;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午4:44 2018/4/4
 */
public class UUIDUtil {

    public UUIDUtil() {
    }

    public static String getId() {
        UUID uuid = UUID.randomUUID();
        return HashUtil.convertToHashStr(uuid.getMostSignificantBits(), 5) + HashUtil.convertToHashStr(uuid
        .getLeastSignificantBits(), 5);
    }
}
