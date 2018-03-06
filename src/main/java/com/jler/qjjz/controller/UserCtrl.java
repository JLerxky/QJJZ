package com.jler.qjjz.controller;

import com.jler.qjjz.entity.UsersEntity;
import com.jler.qjjz.service.UserService;
import com.jler.qjjz.until.UserInfo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.jar.Attributes;

@RestController
@RequestMapping
public class UserCtrl {
    Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        if (session.getAttribute("uAcct") == null) {
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login";
        } else {
            logger.info("------" + session.getAttribute("uAcct") + "已登录,返回前页");
//            model.addAttribute("uAcct", session.getAttribute("uAcct"));
            return "redirect:/";
        }
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header",name="username",dataType="String",
                    required=true,value="用户的姓名",defaultValue="zhaojigang"),
            @ApiImplicitParam(paramType="query",name="password",dataType="String",
                    required=true,value="用户的密码",defaultValue="wangna")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute UsersEntity usersEntity, Model model, HttpSession session,
                            HttpServletRequest request) {
        boolean r = userService.checkPwd(usersEntity);
        //获取ipMac
        Attributes ipMac = UserInfo.iPMac(request);
        model.addAttribute("Result", r);
        if (r) {
//            model.addAttribute("uAcct", usersEntity.getuAcct());
            session.setAttribute("uAcct", usersEntity.getuAcct());
            logger.info("------用户:" + session.getAttribute("uAcct")
                    + " 登录,ip:" + ipMac.getValue("ip"));
            return "redirect:/";
        } else {
            model.addAttribute("result", "用户名或密码错误");
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login";
        }
    }

    @RequestMapping(value = "joinIn", method = RequestMethod.POST)
    public String joinIn(@ModelAttribute UsersEntity usersEntity, Model model, HttpSession session,
                         HttpServletRequest request) {
        UsersEntity u = userService.joinIn(usersEntity);
        //获取ipMac
        Attributes ipMac = UserInfo.iPMac(request);
        if (u != null) {
            model.addAttribute("uAcct", usersEntity.getuAcct());
            session.setAttribute("uAcct", usersEntity.getuAcct());
            logger.info("------新用户:" + session.getAttribute("uAcct")
                    + " 加入,ip:" + ipMac.getValue("ip"));
            return "redirect:/";
        } else {
            model.addAttribute("result", "注册失败");
            model.addAttribute("UsersEntity", new UsersEntity());
            return "login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        String uAcct = session.getAttribute("uAcct").toString();
        session.invalidate();
        logger.info("------用户:" + uAcct + " 已退出,返回登录页");
        model.addAttribute("uAcct", null);
        model.addAttribute("UsersEntity", new UsersEntity());
        return "login";
    }

    @RequestMapping(value = "checkId", method = RequestMethod.POST)
    public String checkUAcct(@RequestBody Map<String,Object> params) {
        UsersEntity u = userService.findByuAcct(params.get("uAcct").toString());
        if (u != null) {
            return "true";
        } else {
            return "false";
        }
    }
}
