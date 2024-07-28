package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: your name
 * @Date: 2024/7/22 14:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//用于封装控制层的两个类数据
public class UserAccountInfoDTO {
    private UserAccount userAccount;
    private UserInfo userInfo;

}
