package com.jler.qjjz.service;

import com.jler.qjjz.entity.UsersEntity;
import com.jler.qjjz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public boolean checkPwd(UsersEntity usersEntity) {
        UsersEntity u = userRepository.findByUId(usersEntity.getuId());
        if (u == null) {
            return false;
        }
        if (u.getuPwd().equals(usersEntity.getuPwd())) {
            return true;
        } else {
            return false;
        }
    }

    public void save(UsersEntity u) {
        userRepository.save(u);
    }

    public UsersEntity findOne(int id) {
        return userRepository.findOne(id);
    }

    public UsersEntity findByUId(String uid) {
        return userRepository.findByUId(uid);
    }
}
