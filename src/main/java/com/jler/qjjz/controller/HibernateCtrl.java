package com.jler.qjjz.controller;

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
public class HibernateCtrl {
    Logger logger = LoggerFactory.getLogger(HibernateCtrl.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index(HttpSession session, Model model) {
        model.addAttribute("uid", session.getAttribute("uid"));
        return "menu/menu-1";
    }

}
