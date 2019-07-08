package com.devil.inventory.service.impl;

import com.devil.inventory.model.common.ErrorCode;
import com.devil.inventory.model.common.auth.EncryptionType;
import com.devil.inventory.model.dao.entity.UserInfoEntity;
import com.devil.inventory.model.service.result.LoginResult;
import com.devil.inventory.service.encry.IEncryProvider;
import com.devil.inventory.service.encry.ProviderFactory;
import com.devil.inventory.service.service.ILoginService;
import com.devil.inventory.service.service.IUserInfoService;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/25-10:24
 *  
 */
@Data
@Component
public class LoginServiceImpl implements ILoginService {
    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private IUserInfoService userInfoService;
    private ProviderFactory factory = ProviderFactory.getInstance();

    @Override
    public LoginResult login(String ident, String passWord) throws Exception {
        UserInfoEntity userInfoEntity = null;
        if (ident == null) {
            return LoginResult.failed(ErrorCode.CODE_ERROR_NULL_USER_IDENT, "ident is null");
        }
        if (StringUtils.isNumeric(ident)) {
            Long id = Long.valueOf(ident);
            userInfoEntity = userInfoService.queryUserInfo(id);
        }
        if (userInfoEntity == null) {
            userInfoEntity = userInfoService.queryUserInfo(ident);
        }

        if (userInfoEntity != null && passWord.equals(userInfoEntity.getPassword())) {
            return LoginResult.success(userInfoEntity);
        }
        return LoginResult.failed(ErrorCode.CODE_ERROR_NOT_FOUND_USER, "no user");
    }

    @Override
    public LoginResult loginEncryption(String ident, String passWord, EncryptionType type) throws Exception {
        IEncryProvider provider = factory.getProvider(type);
        String decrypt = provider.decrypt(passWord, null);
        return login(ident, decrypt);
    }
}
