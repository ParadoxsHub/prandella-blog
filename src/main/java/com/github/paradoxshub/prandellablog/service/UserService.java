package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.Input.InsertUserInput;
import com.github.paradoxshub.prandellablog.Output.InsertUserOutput;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    InsertUserOutput insertUser(InsertUserInput input);
}
