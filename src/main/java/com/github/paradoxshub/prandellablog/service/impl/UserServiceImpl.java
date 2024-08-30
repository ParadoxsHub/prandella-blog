package com.github.paradoxshub.prandellablog.service.impl;

import com.github.paradoxshub.prandellablog.entity.LoginHistory;
import com.github.paradoxshub.prandellablog.input.InsertUserInput;
import com.github.paradoxshub.prandellablog.input.LoginInput;
import com.github.paradoxshub.prandellablog.input.RegisterUserInput;
import com.github.paradoxshub.prandellablog.input.UpdateUserInput;
import com.github.paradoxshub.prandellablog.output.*;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.mappers.UserMapper;
import com.github.paradoxshub.prandellablog.service.UserService;
import com.github.paradoxshub.prandellablog.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService {
    // service主写业务逻辑
    // 如：将数据传入数据库并数据更改，实现output数据的筛选和数值展示

    //注入mapper
    private final UserMapper userMapper;
    List<LoginHistoryOutput> list = new ArrayList<>();

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }



    @Override
    public InsertUserOutput insertUser(InsertUserInput input) {
        // 这里写业务逻辑
        User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getNickname());
        user.setGender(input.getGender());
        user.setCreated_at(Timestamp.from(Instant.now()));
        user.setUpdated_at(Timestamp.from(Instant.now()));
        user.setCreated_by(1L);
        user.setUpdated_by(1L);
        user.setAge(input.getAge());
        user.setAdmin(input.admin());
        user.setBan(false);
        userMapper.insertUser(user);
        return new InsertUserOutput(user.getId());
    }

    @Override
    public UpdateUserOutput updateUser(UpdateUserInput input) {
        User user = new User();
        user.setId(input.getId());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getNickname());
        user.setGender(input.getGender());
        user.setAge(input.getAge());
        user.setAdmin(input.isAdmin());
        user.setPhonenumber(input.getPhonenumber());
        userMapper.updateUser(user);
        return UpdateUserOutput.of(user);
    }

    @Override
    public Long deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public SelectUserListOutput selectUser(int limit, int offset) {

        List<User> users = userMapper.selectUsers(limit, offset);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }



    @Override
    public SelectUserOutput selectUserById(Long id) {
        return SelectUserOutput.of(userMapper.selectUserById(id));
    }

    @Override
    public SelectUserListOutput selectUserByEmail(String email) {
        List<User> users = userMapper.selectUserByEmail(email);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }

    @Override
    public SelectUserListOutput selectUserByUserName(String username) {
        List<User> users = userMapper.selectUserByUserName(username);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }

    @Override
    public SelectUserListOutput selectUserByPhonenumber(String phonenumber) {
        List<User> users = userMapper.selectUserByPhonenumber(phonenumber);

        List<SelectUserOutput> list = new ArrayList<>();
        for (User user : users) {
            list.add(SelectUserOutput.of(user));
        }

        Long total = (long) list.size();

        return new SelectUserListOutput(total, list);
    }



    // 禁止用户
    public Long banUser(Long userId) {
        Optional<User> optionalUser = Optional.ofNullable(userMapper.selectUserById(userId));
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User " + userId + " not found");
        }
        User user = optionalUser.get();
        boolean current_banstatus=user.isBan();
//        user.setBan(!current_banstatus);
        userMapper.updateUserIsBanById(userId, !current_banstatus);
        return userId;
    }

    @Override
    public RegisterUserOutput register(RegisterUserInput input) throws Exception {
        User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername(input.getUsername());
        user.setPassword(input.getFirstPassword());
        user.setEmail(input.getEmail());
        user.setNickname(input.getNickname());
        user.setCreated_at(Timestamp.from(Instant.now()));
        user.setUpdated_at(Timestamp.from(Instant.now()));
        user.setCreated_by(1L);
        user.setUpdated_by(1L);
        userMapper.insertUser(user);
        return new RegisterUserOutput(user.getId());
    }

    @Override
    public LoginOutput login(LoginInput input) {
        List<User> users = null;
        String loginIdentifier = "";
        if (input.getEmail() == null && input.getPhonenumber() == null) {
            loginIdentifier = input.getUsername(); // 输入的是用户名
        } else if (input.getEmail() == null && input.getUsername() == null) {
            loginIdentifier = input.getPhonenumber(); // 输入的是手机号
        }else {
            loginIdentifier = input.getEmail(); // 输入的是邮箱
        }
        if (loginIdentifier.contains("@")) {
            // 可能是邮箱
            users = userMapper.selectUserByEmail(loginIdentifier);
        } else if (loginIdentifier.length() == 11) {
            // 可能是手机号
            users = userMapper.selectUserByPhonenumber(loginIdentifier);
        } else {
            // 可能是用户名
            users = userMapper.selectUserByUserName(loginIdentifier);
        }

        if (users != null && !users.isEmpty()) {
            // 用户存在，继续进行密码匹配
            for (User user : users) {
                if (input.getPassword().equals(user.getPassword())) {
                    // 注意拿一个output来承接筛选出来的用户返回出来的登录信息
                    LoginHistory loginHistory = new LoginHistory();
                    loginHistory.setUser_id(user.getId());
                    loginHistory.setFailure_reason("无");
                    loginHistory.setLogin_success(true);
                    LoginHistoryOutput output = LoginHistoryOutput.of(loginHistory);
                    list.add(output);
                    userMapper.insertLoginHistory(output);
                    return new LoginOutput("登陆成功", TokenUtils.generateToken(input));
                } else {
                    // 密码错误
                    LoginHistory loginHistory = new LoginHistory();
                    loginHistory.setUser_id(user.getId());
                    loginHistory.setFailure_reason("登陆失败，密码错误");
                    loginHistory.setLogin_success(false);
                    LoginHistoryOutput output = LoginHistoryOutput.of(loginHistory);
                    list.add(output);
                    userMapper.insertLoginHistory(output);
                }
            }
            return new LoginOutput("登陆失败，密码错误");
        } else {
            // 用户不存在，返回“该账户未注册”
            LoginHistory loginHistory = new LoginHistory();
            loginHistory.setUser_id(0L);
            loginHistory.setFailure_reason("该账户未注册");
            loginHistory.setLogin_success(false);
            LoginHistoryOutput output = LoginHistoryOutput.of(loginHistory);
            list.add(output);
            userMapper.insertLoginHistory(output);
            return new LoginOutput("该账户未注册");
        }
    }

    @Override
    public LoginHistoryListOutput selectLoginHistory ( int limit, int offset){
        List<LoginHistory> loginHistories = userMapper.selectLoginHistory(limit, offset);
        Long total = (long) loginHistories.size();
        return new LoginHistoryListOutput(total, loginHistories);
    }


}

