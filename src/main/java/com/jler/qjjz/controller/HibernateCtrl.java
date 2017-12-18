package com.jler.qjjz.controller;

import com.jler.qjjz.entity.UsersEntity;
import com.jler.qjjz.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hibernate")
@EnableAutoConfiguration
public class HibernateCtrl {
    Logger logger = LoggerFactory.getLogger(HibernateCtrl.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("getUserById")
    @ResponseBody
    public UsersEntity getUserById(int id) {
        UsersEntity u = userRepository.findOne(id);
        logger.info("userRepository: " + userRepository);
        logger.info("id: " + id);
        return u;
    }

}
