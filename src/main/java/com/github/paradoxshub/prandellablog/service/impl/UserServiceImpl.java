package com.github.paradoxshub.prandellablog.service.impl;

import com.github.paradoxshub.prandellablog.Input.InsertUserInput;
import com.github.paradoxshub.prandellablog.Output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.mappers.UserMapper;
import com.github.paradoxshub.prandellablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    //注入mapper
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public InsertUserOutput insertUser(InsertUserInput input) {
        // 这里写业务逻辑

        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getUsername());
        user.setCreated_by(0L);
        user.setUpdated_by(0L);

        Long count = userMapper.insertUser(user);
        System.out.println(count);
        return new InsertUserOutput(user.getId());
    }

//    public List<User> updateUser() {
//        return userMapper.updateUser();
//    }
//
//
//    public List<User> deleteUserByUsernameAndPassword() {
//        return userMapper.deleteUserByUsernameAndPassword();
//    }
//
//    public List<User> deleteUserByEmailAndPassword() {
//        return userMapper.deleteUserByEmailAndPassword();
//    }
//
//    public List<User> deleteUserByIdAndPassword() {
//        return userMapper.deleteUserByIdAndPassword();
//    }
//
//    public List<User> deleteUserByPhoneNumberAndPassword() {
//        return userMapper.deleteUserByPhoneNumberAndPassword();
//    }
//
//    public List<User> searchUserById() {
//        return userMapper.searchUserById();
//    }
//
//    public List<User> searchUserByEmail() {
//        return userMapper.searchUserByEmail();
//    }
//
//    public List<User> searchUserByUsername() {
//        return userMapper.searchUserByUsername();
//    }
//
//    public List<User> searchUserByPhoneNumber() {
//        return userMapper.searchUserByPhoneNumber();
//    }
}
