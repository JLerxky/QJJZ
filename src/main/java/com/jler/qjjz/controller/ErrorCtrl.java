package com.jler.qjjz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ErrorCtrl implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorCtrl.class);

    @Override
    public String getErrorPath() {
        logger.info("出错啦！进入自定义错误控制器");
        return "404";
    }

    @RequestMapping(value = "404")
    public String error() {
        return getErrorPath();
    }

}
