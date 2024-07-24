package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.output.SelectUserOutput;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    InsertUserOutput insertUser(InsertUserInput input);
    SelectUserOutput selectUserById(Long id);

    Long deleteUser(Long id);
}
