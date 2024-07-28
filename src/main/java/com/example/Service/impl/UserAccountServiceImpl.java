package com.example.Service.impl;

import com.example.Service.UserAccountService;
import com.example.mapper.UserAccountMapper;
import com.example.pojo.UserAccount;
import com.example.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: your name
 * @Date: 2024/7/19 14:44
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountMapper userAccountMapper;

    @Override
    public List<UserAccount> findAll() {

        return userAccountMapper.findAll();

    }

    @Override
    public void deleteById(List<Integer> ids) {
        //System.out.println(ids+"到mapper");
        userAccountMapper.deleteById(ids);
    }

    @Override
    public void update(UserAccount userAccount) {
        userAccountMapper.update(userAccount);
    }

    @Override
    public UserAccount getById(Integer id) {
        return userAccountMapper.getById(id);
    }

    @Override
    @Transactional
    public void addUserAccount(UserAccount userAccount, UserInfo userInfo) {
        userAccountMapper.insertUserAccount(userAccount);
        userAccountMapper.insertUserInfo(userInfo);
    }

    @Override
    @Transactional
    public void updateUserAccountAndInfo(UserAccount userAccount, UserInfo userInfo) {
        // 更新useraccount表
        userAccountMapper.updateUserAccountInfo(userAccount);
        // 更新userinfo表
        userAccountMapper.updateUserInfo(userInfo);
    }

    @Override
    public void deleteUserAccountById(List<Integer> ids) {
        userAccountMapper.deleteUserInfoById(ids);
        userAccountMapper.deleteById(ids);//这个我没改名字不然应该重写一个方法加deleteUserById

    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userAccountMapper.getUserInfoById(id);
    }
}
