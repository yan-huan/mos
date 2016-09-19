package com.myb.mos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myb.accounts.service.AccountsAccountService;

@Controller
@RequestMapping("/User")
public class AccountsAccountController {
    @Autowired
    private AccountsAccountService accountsAccountService;
    
    
     
}
