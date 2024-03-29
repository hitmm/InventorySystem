package com.devil.inventory.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.devil.inventory.dao.service.IUserInfoDAO;
import com.devil.inventory.model.dao.entity.UserInfoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/19-18:15
 *  
 */
@Component
public class UserInfoDAO extends BaseDAO implements IUserInfoDAO {

    private final static String DELETE_ID_HQL = "delete from UserInfoEntity where id = ?0";
    private final static String QUERY_NAME_HQL = "from UserInfoEntity where userName = ?0";
    private final static String QUERY_ID_HQL = "from UserInfoEntity where id = ?0";
    private final static String COUNT_USER_HQL = "select count(1) from UserInfoEntity;";

    public static void main(String[] args) throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoDAO().queryUserInfoById(1212L);
        System.out.println(JSONObject.toJSONString(userInfoEntity));
    }

    @Override
    public Long insertUserInfo(UserInfoEntity entity) throws Exception {
        return save(entity);
    }

    @Override
    public Long updateOrInsertUserInfo(UserInfoEntity entity) throws Exception {
        if(entity.getId()!=null&&entity.getId()>0){
            return updateUserInfo(entity);
        }
        return insertUserInfo(entity);
    }

    @Override
    public Long updateUserInfo(UserInfoEntity entity) throws Exception {
        update(entity);
        return entity.getId();
    }

    @Override
    public Integer countUserInfo() throws Exception {
        return count(COUNT_USER_HQL, null);
    }

    @Override
    public UserInfoEntity queryUserInfoById(Long id) throws Exception {
        return query(id, UserInfoEntity.class);
    }

    @Override
    public UserInfoEntity queryUserInfoByName(String userName) throws Exception {
        List<UserInfoEntity> resultTmp = query(QUERY_NAME_HQL, new Object[]{userName});
        if (resultTmp == null || resultTmp.isEmpty()) {
            return null;
        }
        return resultTmp.get(0);
    }

    @Override
    public boolean deleteUserInfo(Long id) {
        delete(DELETE_ID_HQL, new Object[]{id});
        return true;
    }

    @Override
    public List<UserInfoEntity> queryUserInfoCustom(String sql, Object[] params) throws Exception {
        return nativeQuery(sql, params, UserInfoEntity.class);
    }

}
