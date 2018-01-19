package com.jler.qjjz.controller;


import com.jler.qjjz.entity.UsersEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class ModelCtrl {
    Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @RequestMapping(value = "loginView", method = RequestMethod.POST)
    public String loginView(Model model) {
        model.addAttribute("UsersEntity",new UsersEntity());
        return "model/loginForm";
    }
}
