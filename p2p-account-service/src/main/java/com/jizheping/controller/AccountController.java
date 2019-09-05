package com.jizheping.controller;

import com.jizheping.api.entity.Account;
import com.jizheping.api.vo.CodeMsg;
import com.jizheping.api.vo.ResultVO;
import com.jizheping.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/insertAccount")
    public ResultVO<Account> createAccount(@RequestBody Long id){
        System.out.println(id);

        Account account = Account.empty(id);

        try {
            accountService.createAccount(account);
        }catch (Exception e){
            return ResultVO.error(CodeMsg.ACCOUNT_CREATE_FALL);
        }

        return ResultVO.success(account);
    }
}
