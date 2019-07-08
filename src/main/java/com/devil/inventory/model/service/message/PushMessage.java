package com.devil.inventory.model.service.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 服务端推送信息
 * @Author huguangyin
 * @Date 2019/6/28-14:11
 *  
 */
@Data
public class PushMessage extends Message implements Serializable {

    private String content;
    private String picUrl;
}
