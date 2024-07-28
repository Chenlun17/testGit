package com.example.mapper;

import com.example.pojo.UserAccount;
import com.example.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Author: your name
 * @Date: 2024/7/19 14:45
 */
@Mapper
public interface UserAccountMapper {
//     @Select("select * from UserAccount")
     List<UserAccount> findAll();

     void deleteById(@Param("ids") List<Integer> ids);

     void update(UserAccount userAccount);

     UserAccount getById(Integer id);


     //下面是两表
     //这两个应该是事务，向两个表插入，id自动生成
     void insertUserAccount(UserAccount userAccount);
     void insertUserInfo(UserInfo userInfo);

     //更新
     void updateUserAccountInfo( UserAccount userAccount);
     void updateUserInfo( UserInfo userInfo);

     //删除
     void deleteUserInfoById(@Param("ids") List<Integer> ids);

     UserInfo getUserInfoById(Integer id);

}
