package com.github.paradoxshub.prandellablog.service.impl;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
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
        user.setNickname(input.getNickname());
        user.setGender(input.getGender());
        user.setCreated_by(0L);
        user.setUpdated_by(0L);
        user.setAge(input.getAge());

        Long count = userMapper.insertUser(user);
        System.out.println(count);
        return new InsertUserOutput(user.getId());
    }

    @Override
    public Long deleteUser(Long id) {
        return userMapper.deleteUserById(id);
    }
}
