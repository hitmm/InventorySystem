package com.devil.inventory.service.serverpush;

import com.devil.inventory.model.service.message.PushMessage;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/28-14:29
 *  
 */
public interface IPushService {
    /**
     * 向在线用户推送消息
     *
     * @param message
     * @throws Exception
     */
    void push(PushMessage message) throws Exception;
}
