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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UserCtrl {
    Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        if (session.getAttribute("uid") == null) {
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login/login-1";
        } else {
            logger.info("------" + session.getAttribute("uid") + "已登录,返回之前页------");
            model.addAttribute("uid", session.getAttribute("uid"));
            return "menu/menu-1";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute UsersEntity usersEntity, Model model, HttpSession session) {
        boolean r = userService.checkPwd(usersEntity);
        model.addAttribute("Result", r);
        if (r) {
            model.addAttribute("uid", usersEntity.getuId());
            session.setAttribute("uid", usersEntity.getuId());
            return "redirect:/";
        }else{
            model.addAttribute("result", "用户名或密码错误");
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login/login-1";
        }
    }

    @RequestMapping(value = "joinIn", method = RequestMethod.POST)
    public String joinIn(@ModelAttribute UsersEntity usersEntity, Model model, HttpSession session) {
        UsersEntity u = userService.save(usersEntity);
        if(u != null){
            model.addAttribute("uid", usersEntity.getuId());
            session.setAttribute("uid", usersEntity.getuId());
            return "redirect:/";
        }else{
            model.addAttribute("result", "注册失败");
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login/login-1";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        String uid = session.getAttribute("uid").toString();
        session.invalidate();
        logger.info("------" + uid + "已退出,返回登录页------");
        model.addAttribute("uid", null);
        model.addAttribute("UsersEntity", new UsersEntity());
        return "login/login-1";
    }
}
