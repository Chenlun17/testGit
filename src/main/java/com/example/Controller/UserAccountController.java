package com.example.Controller;

import com.example.Service.UserAccountService;
import com.example.pojo.Result;
import com.example.pojo.UserAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: your name
 * @Date: 2024/7/19 14:37
 */
@Slf4j
@RestController
@RequestMapping("/UserAccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;
    //http://localhost:8080/UserAccount
    @GetMapping
    public Result findAll(){
        List<UserAccount> userAccounts = userAccountService.findAll();
        return Result.success(userAccounts);
    }
    //http://localhost:8080/UserAccount/1,2,3
    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable List<Integer> ids){
        log.info("删除请求:{}",ids);
        userAccountService.deleteById(ids);
        return Result.success();
    }
    /*
    http://localhost:8080/UserAccount
    {
            "id": 4,
            "account": "jpk",
            "password": "123456"
    }
    */
    @PutMapping
    public Result update(@RequestBody UserAccount userAccount){
        log.info("更新员工信息:{}",userAccount);
        userAccountService.update(userAccount);
        return Result.success();
    }

    /*http://localhost:8080/UserAccount/4*/
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据员工id查询,{}",id);
        UserAccount userAccount = userAccountService.getById(id);
        return Result.success(userAccount);
    }

//    @PostMapping
//    public Result addUserAccount(@RequestBody UserAccount userAccount){
//        log.info("新增部门{}",userAccount);
//
//    }
}
