package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.Input.AddUserInput;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //注入mapper
    @Autowired
    private UserMapper userMapper;

    public List<User> addUser(AddUserInput addUserInput){
        return  userMapper.addUser();
    }

    public List<User> updateUser(){
        return userMapper.updateUser();
    }


    public List<User> deleteUserByUsernameAndPassword(){
        return userMapper.deleteUserByUsernameAndPassword();
    }

    public List<User> deleteUserByEmailAndPassword(){
        return userMapper.deleteUserByEmailAndPassword();
    }

    public List<User> deleteUserByIdAndPassword(){
        return userMapper.deleteUserByIdAndPassword();
    }
    public List<User> deleteUserByPhoneNumberAndPassword(){
        return userMapper.deleteUserByPhoneNumberAndPassword();
    }

    public List<User> searchUserById(){
        return userMapper.searchUserById();
    }

    public List<User> searchUserByEmail(){
        return userMapper.searchUserByEmail();
    }

    public List<User> searchUserByUsername(){
        return userMapper.searchUserByUsername();
    }

     public List<User> searchUserByPhoneNumber(){
        return userMapper.searchUserByPhoneNumber();
    }
}
