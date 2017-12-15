package com.jler.qjjz.controller;

import com.jler.qjjz.entity.UsersEntity;
import com.jler.qjjz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hibernate")
@EnableAutoConfiguration
public class HibernateCtrl {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("getUserById")
    @ResponseBody
    public UsersEntity getUserById(int id) {
        UsersEntity u = userRepository.findOne(id);
        System.out.println("userRepository: " + userRepository);
        System.out.println("id: " + id);
        return u;
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public void saveUser() {
        UsersEntity u = new UsersEntity();
        u.setuName("baby");
        u.setId(2);
        u.setuId("zpb");
        u.setuPwd("4721");
        userRepository.save(u);
    }


}
