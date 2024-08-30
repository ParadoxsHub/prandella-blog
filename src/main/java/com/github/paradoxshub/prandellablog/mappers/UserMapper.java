package com.github.paradoxshub.prandellablog.mappers;

import com.github.paradoxshub.prandellablog.entity.LoginHistory;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.output.LoginHistoryOutput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {
    // 对数据库进行操作
    // 添加新用户
    Long insertUser(User user);

    // 增加用户登陆历史(返回值位主键的类型)
    Long insertLoginHistory(LoginHistoryOutput output);

    // 修改用户信息
    Long updateUser(User user);

    // 通过id删除用户
    Long deleteUserById(@Param("id") Long id);

    // 通过id查询用户
    User selectUserById(@Param("id") Long id);

    // 通过username查询用户
    List<User> selectUserByUserName(@Param("username") String username);

    // 通过email查询用户
    List<User> selectUserByEmail(@Param("email") String email);

    //
    List<User> selectUserByPhonenumber(@Param("phonenumber") String phonenumber);

    // 查询所有用户
    List<User> selectUsers(@Param("limit") int limit, @Param("offset") int offset);

    //查询登录历史记录
    List<LoginHistory> selectLoginHistory(@Param("limit") int limit, @Param("offset") int offset);

    //禁止用户
    Long updateUserIsBanById(@Param("id") Long id,@Param("ban") Boolean ban);
}
