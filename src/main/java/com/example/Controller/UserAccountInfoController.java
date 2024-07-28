package com.example.Controller;

import com.example.Service.UserAccountService;
import com.example.pojo.Result;
import com.example.pojo.UserAccount;
import com.example.pojo.UserAccountInfoDTO;
import com.example.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: your name
 * @Date: 2024/7/22 14:14
 */
@Slf4j
@RestController
@RequestMapping("/UserAccountInfo")
public class UserAccountInfoController {

    @Autowired
    private UserAccountService userAccountService;
//    http://localhost:8080/UserAccountInfo
    // 新增方法，用于添加用户账户和信息

    /*
{
    "userAccount": {
        "id": 1,
        "account": "zhangsan",
        "password": "123456"
    },
    "userInfo": {
        "id": 2,
        "name": "张三",
        "age": 25,
        "gender": "男",
        "idCard": "123456789012345678"
    }
}

    * */
    @PostMapping
    public Result addUserAccount(@RequestBody UserAccountInfoDTO userAccountInfoDTO){
        log.info("新增用户账户:{}", userAccountInfoDTO.getUserAccount());
        log.info("新增用户信息:{}", userAccountInfoDTO.getUserInfo());
        userAccountService.addUserAccount(userAccountInfoDTO.getUserAccount(), userAccountInfoDTO.getUserInfo());
        return Result.success();
    }
/*
{
    "userAccount": {
        "id": 1,
        "account": "更新测试",
        "password": "123456"
    },
    "userInfo": {
        "id": 1,
        "name": "张三（更新后）",
        "age": 25,
        "gender": "男",
        "idCard": "123456789012345678"
    }
}* */
    // 修改更新方法，以接收用户信息和账户
    @PutMapping
    public Result update(@RequestBody UserAccountInfoDTO userAccountInfoDTO){
        log.info("更新用户账户信息:{}", userAccountInfoDTO.getUserAccount());
        log.info("更新用户个人信息:{}", userAccountInfoDTO.getUserInfo());
        userAccountService.updateUserAccountAndInfo(userAccountInfoDTO.getUserAccount(), userAccountInfoDTO.getUserInfo());
        return Result.success();
    }

/*
{
        "userAccount": {
        "id": 1

    },
        "userInfo": {
        "id": 1

    }
    }
* */
//    http://localhost:8080/UserAccountInfo/1,2
    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable List<Integer> ids){
        log.info("删除请求:{}",ids);
        userAccountService.deleteUserAccountById(ids);
        return Result.success();
    }

    //http://localhost:8080/UserAccountInfo/6
    /*
    return
    {
	"code": 1,
	"msg": "success",
	"data": {
		"userAccount": {
			"id": 6,
			"account": "wangwu",
			"password": "password789"
		},
		"userInfo": {
			"id": 6,
			"name": "王五",
			"age": 28,
			"gender": "男",
			"idCard": "456789012345678901"
		}
	}
}
    * */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据员工id查询,{}",id);
        //理论上我感觉这个更应该放在service层，但我为了方便放在控制层
        UserAccount userAccount = userAccountService.getById(id);//一样的这边名字该改成getUserAccountById，由于我之前写过就拿过来用了
        UserInfo userInfo = userAccountService.getUserInfoById(id);

        UserAccountInfoDTO userAccountInfoDTO  = new UserAccountInfoDTO(userAccount,userInfo);
        return Result.success(userAccountInfoDTO);

    }
}
