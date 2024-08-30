package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.input.LoginInput;
import com.github.paradoxshub.prandellablog.input.RegisterUserInput;
import com.github.paradoxshub.prandellablog.input.UpdateUserInput;
import com.github.paradoxshub.prandellablog.output.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    // Service接口写出整体方法，Impl具体实施通过继承重写
    InsertUserOutput insertUser(InsertUserInput input);

    UpdateUserOutput updateUser(UpdateUserInput input);

    Long deleteUserById(Long id);

    SelectUserOutput selectUserById(Long id);

    SelectUserListOutput selectUserByEmail(String email);

    SelectUserListOutput selectUserByUserName(String username);

    SelectUserListOutput selectUserByPhonenumber(String phonenumber);

    SelectUserListOutput selectUser(int limit, int offset);

    LoginHistoryListOutput selectLoginHistory(int limit, int offset);

    Long banUser(Long userId);

    RegisterUserOutput register(RegisterUserInput input) throws Exception;

    LoginOutput login(LoginInput input);

}
