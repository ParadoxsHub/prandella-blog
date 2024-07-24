package com.github.paradoxshub.prandellablog.service;

import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.output.InsertUserOutput;
import com.github.paradoxshub.prandellablog.output.SelectUserListOutput;
import org.springframework.data.domain.Sort;
import com.github.paradoxshub.prandellablog.output.SelectUserOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    InsertUserOutput insertUser(InsertUserInput input);

    Long deleteUserById(Long id);

    SelectUserOutput selectUserById(Long id);

    SelectUserListOutput selectUser(int limit, int offset);
}
