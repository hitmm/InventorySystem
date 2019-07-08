package com.devil.inventory.service.service;


import com.devil.inventory.model.common.auth.EncryptionType;
import com.devil.inventory.model.service.result.LoginResult;

/**
 * @Description 登录服务
 * @Author huguangyin
 * @Date 2019/6/25-10:12
 *  
 */
public interface ILoginService {
    /**
     * 明文登录
     *
     * @param ident
     * @param passWord
     * @return
     * @throws Exception
     */
    LoginResult login(String ident, String passWord) throws Exception;

    /**
     * 加密密码登录
     *
     * @param ident
     * @param passWord
     * @return
     * @throws Exception
     */
    LoginResult loginEncryption(String ident, String passWord, EncryptionType type) throws Exception;
}
