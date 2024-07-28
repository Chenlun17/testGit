package com.example.Service;

import com.example.pojo.UserAccount;
import com.example.pojo.UserInfo;

import java.util.List;

public interface UserAccountService {

    //查询所有用户账号
    List<UserAccount> findAll();
    //根据id删除
    void deleteById(List<Integer> ids);
    //更新
    void update(UserAccount userAccount);
    //通过id删
    UserAccount getById(Integer id);


    //增加账户密码和信息
    void addUserAccount(UserAccount userAccount, UserInfo userInfo);

    //更新账号密码和信息
    void updateUserAccountAndInfo(UserAccount userAccount, UserInfo userInfo);

    //删除用户的密码和信息
    void deleteUserAccountById(List<Integer> ids);

    //根据id查询
    UserInfo getUserInfoById(Integer id);
}
