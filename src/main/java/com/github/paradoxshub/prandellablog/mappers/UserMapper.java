package com.github.paradoxshub.prandellablog.mappers;

import com.github.paradoxshub.prandellablog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface UserMapper {

    //添加新用户
    Long insertUser(User user);
    //修改用户
    Long updateUserById(User user);

    Long deleteUserById(@Param("id") Long id);

}
