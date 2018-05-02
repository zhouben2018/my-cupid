package com.zben.cupid.commons;

import java.util.List;
import java.util.Map;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午2:34 2018/4/26
 */
public class AuthNHolder {

    /**
     * 针对一个资源Code是否有访问权限
     * @param resCode
     * @return
     */
    public static boolean hasResAccess(String resCode) {
        if (!hasResource()) {
            //如果数据源没有资源, 直接放过
            return true;
        }
        List<String> list = resCodes();
        return list.contains(resCode);
    }

    private static List<String> resCodes() {
        return null;
    }

    private static boolean hasResource() {
        String hasResource = get("hasResource");
        return "true".equals(hasResource);
    }

    private static String get(String key) {
        Map<String, String> map = getMap();
        return map.get(key);
    }

    private static Map<String, String> getMap() {
        return null;
    }
}
































