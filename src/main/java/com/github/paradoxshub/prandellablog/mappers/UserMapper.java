package com.github.paradoxshub.prandellablog.mappers;

import com.github.paradoxshub.prandellablog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    //添加新用户
    Long insertUser(User user);

    User updateUser(Long id);

    Long deleteUserById(@Param("id") Long id);

    User selectUserById(@Param("id") Long id);

    List<User> selectUserByUserName(@Param("username") String username);

    List<User> selectUserByEmail(@Param("email") String email);

    List<User> selectUsers(@Param("limit") int limit, @Param("offset") int offset);

    Long selectUsersTotal();
}
