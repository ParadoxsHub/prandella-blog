package com.github.paradoxshub.prandellablog.mappers;

import com.github.paradoxshub.prandellablog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface UserMapper {

    //添加新用户
    Long insertUser(User user);
    User selectUserById(@Param("id") Long id);

    Long deleteUserById(@Param("id") Long id);


//    //修改用户信息
//    List<User> updateUser();
//
//    //注销或封禁用户
//    List<User> deleteUserByUsernameAndPassword();
//
//    List<User> deleteUserByEmailAndPassword();
//
//    List<User> deleteUserByIdAndPassword();
//
//    List<User> deleteUserByPhoneNumberAndPassword();
//
//    //查找用户
//    List<User> searchUserById();
//
//    List<User> searchUserByEmail();
//
//    List<User> searchUserByUsername();
//
//    List<User> searchUserByPhoneNumber();
}
