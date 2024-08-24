package com.github.paradoxshub.prandellablog.service.impl;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.input.RegisterUserInput;
import com.github.paradoxshub.prandellablog.input.UpdateUserInput;
import com.github.paradoxshub.prandellablog.output.*;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.mappers.UserMapper;
import com.github.paradoxshub.prandellablog.service.UserService;
import com.github.paradoxshub.prandellablog.util.AesEncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService {
    // service主写业务逻辑
    // 如：将数据传入数据库并数据更改，实现output数据的筛选和数值展示

    //注入mapper
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public RegisterUserOutput registerUser(RegisterUserInput input) throws Exception {
        User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername(input.getUsername());
        user.setPassword(input.getFirstPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getNickname());
        user.setCreated_at(Timestamp.from(Instant.now()));
        user.setUpdated_at(Timestamp.from(Instant.now()));
        user.setCreated_by(1L);
        user.setUpdated_by(1L);
        userMapper.insertUser(user);
        return new RegisterUserOutput(user.getId());
    }

    @Override
    public InsertUserOutput insertUser(InsertUserInput input) {
        // 这里写业务逻辑
        User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getNickname());
        user.setGender(input.getGender());
        user.setCreated_at(Timestamp.from(Instant.now()));
        user.setUpdated_at(Timestamp.from(Instant.now()));
        user.setCreated_by(1L);
        user.setUpdated_by(1L);
        user.setAge(input.getAge());
        user.setAdmin(input.admin());
        user.setBan(false);
        userMapper.insertUser(user);
        return new InsertUserOutput(user.getId());
    }

    @Override
    public UpdateUserOutput updateUser(UpdateUserInput input) {
        User user = new User();
        user.setId(input.getId());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getNickname());
        user.setGender(input.getGender());
        user.setAge(input.getAge());
        user.setAdmin(input.isAdmin());
        userMapper.updateUser(user);
        return UpdateUserOutput.of(user);
    }

    @Override
    public Long deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public SelectUserListOutput selectUser(int limit, int offset) {

        List<User> users = userMapper.selectUsers(limit, offset);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }

    @Override
    public SelectUserOutput selectUserById(Long id) {
        return SelectUserOutput.of(userMapper.selectUserById(id));
    }

    @Override
    public SelectUserListOutput selectUserByEmail(String email) {
        List<User> users = userMapper.selectUserByEmail(email);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }

    @Override
    public SelectUserListOutput selectUserByUserName(String username) {
        List<User> users = userMapper.selectUserByUserName(username);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }

}
