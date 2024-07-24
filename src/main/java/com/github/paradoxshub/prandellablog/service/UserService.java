package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    InsertUserOutput insertUser(InsertUserInput input);

    Long deleteUser(Long id);
}
