package com.jler.qjjz.controller;

import com.jler.qjjz.entity.UsersEntity;
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
public class UserCtrl {
    Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        if (session.getAttribute("uAcct") == null) {
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login/login-1";
        } else {
            logger.info("------" + session.getAttribute("uAcct") + "已登录,返回之前页------");
            model.addAttribute("uAcct", session.getAttribute("uAcct"));
            return "menu/menu-1";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute UsersEntity usersEntity, Model model, HttpSession session) {
        boolean r = userService.checkPwd(usersEntity);
        model.addAttribute("Result", r);
        if (r) {
            model.addAttribute("uAcct", usersEntity.getuAcct());
            session.setAttribute("uAcct", usersEntity.getuAcct());
            return "redirect:/";
        }else{
            model.addAttribute("result", "用户名或密码错误");
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login/login-1";
        }
    }

    @RequestMapping(value = "joinIn", method = RequestMethod.POST)
    public String joinIn(@ModelAttribute UsersEntity usersEntity, Model model, HttpSession session) {
        UsersEntity u = userService.joinIn(usersEntity);
        if(u != null){
            model.addAttribute("uAcct", usersEntity.getuAcct());
            session.setAttribute("uAcct", usersEntity.getuAcct());
            return "redirect:/";
        }else{
            model.addAttribute("result", "注册失败");
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login/login-1";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        String uAcct = session.getAttribute("uAcct").toString();
        session.invalidate();
        logger.info("------" + uAcct + "已退出,返回登录页------");
        model.addAttribute("uAcct", null);
        model.addAttribute("UsersEntity", new UsersEntity());
        return "login/login-1";
    }
}
