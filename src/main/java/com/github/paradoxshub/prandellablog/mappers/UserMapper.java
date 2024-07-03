package com.github.paradoxshub.prandellablog.mappers;

import com.github.paradoxshub.prandellablog.entity.User;

import java.util.List;


public interface UserMapper {
    //修改用户信息
    List<User> updateUser();
    //添加新用户
    List<User> addUser();

    //注销或封禁用户
    List<User> deleteUserByUsernameAndPassword();
    List<User> deleteUserByEmailAndPassword();
    List<User> deleteUserByIdAndPassword();
    List<User> deleteUserByPhoneNumberAndPassword();
    //查找用户
    List<User> searchUserById();
    List<User> searchUserByEmail();
    List<User> searchUserByUsername();
    List<User> searchUserByPhoneNumber();
}
