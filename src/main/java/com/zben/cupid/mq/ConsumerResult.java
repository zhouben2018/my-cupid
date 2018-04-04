package com.zben.cupid.mq;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:03 2018/4/4
 */
public enum ConsumerResult {
    CommitMessage("CommitMessage", "消费成功, 继续消费下一条消息"),
        ReconsumeLater("ReconsumeLater", "消费失败, 告知服务器稍后再投送整条消息, 继续消费其他消息");

    private String code;
    private String desc;

    private ConsumerResult(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
