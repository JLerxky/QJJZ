package com.jler.qjjz.controller;

import com.jler.qjjz.entity.UsersEntity;
import com.jler.qjjz.service.AccountService;
import com.jler.qjjz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@EnableAutoConfiguration
public class InitCtrl {
    Logger logger = LoggerFactory.getLogger(InitCtrl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/")
    public String index(HttpSession session, Model model) {
        String uAcct = session.getAttribute("uAcct").toString();
        model.addAttribute("uAcct", uAcct);
        if(uAcct != null){
            init(uAcct,model);
        }
        return "index";
    }

    public void init(String uAcct,Model model){
        UsersEntity u = userService.findByuAcct(uAcct);
        model.addAttribute("user",u);
        model.addAttribute("accounts",accountService.findAllByuId(u.getId()));
    }

}
