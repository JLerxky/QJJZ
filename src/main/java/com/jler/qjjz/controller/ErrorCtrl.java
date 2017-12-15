package com.jler.qjjz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping(value = "error")
//public class ErrorCtrl implements ErrorController {
//    private static final Logger logger = LoggerFactory.getLogger(ErrorCtrl.class);
//
//    @Override
//    public String getErrorPath() {
//        logger.info("出错啦！进入自定义错误控制器");
//        return "error/error";
//    }
//
//    @RequestMapping
//    public String error(Model model) {
//        model.addAttribute("code", HttpStatus.NOT_FOUND);
//        String errorPath = getErrorPath();
//        return errorPath;
//    }

//}
