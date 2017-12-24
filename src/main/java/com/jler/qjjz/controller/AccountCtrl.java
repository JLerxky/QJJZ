package com.jler.qjjz.controller;


import com.jler.qjjz.entity.AccountEntity;
import com.jler.qjjz.entity.UsersEntity;
import com.jler.qjjz.service.AccountService;
import com.jler.qjjz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class AccountCtrl {
    Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    public void addAccount(@ModelAttribute AccountEntity accountEntity, HttpSession session, Model model) {
        String uAcct = session.getAttribute("uAcct").toString();
        UsersEntity u = userService.findByuAcct(uAcct);
        accountEntity.setuId(u.getId());
        accountService.add(accountEntity);
        modelUpdate(model,u.getId());
    }

    public void modelUpdate(Model model,Integer uid){
        Iterable<AccountEntity> accounts = accountService.findAllByuId(uid);
        model.addAttribute("accounts", accounts);
    }
}
