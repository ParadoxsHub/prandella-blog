package com.github.paradoxshub.prandellablog.service.impl;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.mappers.UserMapper;
import com.github.paradoxshub.prandellablog.output.SelectUserListOutput;
import com.github.paradoxshub.prandellablog.output.SelectUserOutput;
import com.github.paradoxshub.prandellablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
        user.setAdmin(input.admin());
        user.setBan(false);

        Long count = userMapper.insertUser(user);
        System.out.println(count);
        return new InsertUserOutput(user.getId());
    }


    public  List<SelectUserListOutput> selectUser(int limit, int offset) {

        List<User> users = userMapper.selectUsers(limit, offset);

        List<SelectUserListOutput> outputs = new ArrayList<>();
        for (User user : users) {
            SelectUserListOutput output = new SelectUserListOutput();
            output.setId(user.getId());
            output.setUsername(user.getUsername());
            output.setNickname(user.getNickname());
            output.setEmail(user.getEmail());
            output.setGender(user.getGender());
            output.setAge(user.getAge());
            output.setCreated_at(user.getCreated_at());
            output.setUpdated_at(user.getUpdated_at());
            output.setDeleted_at(user.getDeleted_at());
            output.setAdmin(user.isAdmin());
            output.setBan(user.isBan());
            output.setAvatar(user.getAvatar());
            outputs.add(output);
        }

        return outputs;
    }

    @Override
    public SelectUserOutput selectUserById(Long id) {

        User user = userMapper.selectUserById(id);
        SelectUserOutput output = new SelectUserOutput();
        output.setId(user.getId());
        output.setUsername(user.getUsername());
        output.setNickname(user.getNickname());
        output.setEmail(user.getEmail());
        output.setGender(user.getGender());
        output.setAge(user.getAge());
        output.setCreated_at(user.getCreated_at());
        output.setUpdated_at(user.getUpdated_at());
        output.setDeleted_at(user.getDeleted_at());
        output.setAdmin(user.isAdmin());
        output.setBan(user.isBan());
        output.setAvatar(user.getAvatar());

        return output;
    }

    @Override
    public Long deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }
}
