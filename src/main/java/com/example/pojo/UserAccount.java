package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: your name
 * @Date: 2024/7/19 14:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    private Long id;

    private String account;

    private String password;

    //private UserInfo userInfo;
}
