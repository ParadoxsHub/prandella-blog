package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.input.UpdateUserInput;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.output.UpdateUserOutput;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    InsertUserOutput insertUser(InsertUserInput input);

    UpdateUserOutput updateUser(UpdateUserInput input);

    Long deleteUser(Long id);
}
