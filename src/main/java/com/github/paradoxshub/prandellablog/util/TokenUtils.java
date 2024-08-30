package com.github.paradoxshub.prandellablog.util;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.jwt.JWTUtil;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.input.LoginInput;

import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    static String key = "0123456789_0123456789_0123456789";

    /**
     * 生成 token
     */
    public static String generateToken(LoginInput input){
        Map<String, Object> usermap = new HashMap<>();
        User user = new User();
        usermap.put("username", user.getUsername());
        usermap.put("nickname",user.getNickname());
        usermap.put("age",user.getAge());
        usermap.put("email",user.getEmail());
        usermap.put("createdAt",user.getCreated_at());
        usermap.put("avatar",user.getAvatar());
        return JWTUtil.createToken(usermap,key.getBytes());
    }

    /**
     * 验证token
     */
    public static boolean verifyToken() {
        // 获取请求携带的令牌
        String token = ServletUtil.getRequest().getHeader("Authorization");
        // 去除 token 前缀
        if (CharSequenceUtil.isNotBlank(token) && token.startsWith("Bearer")) {
            token = token.replace("Bearer", CharSequenceUtil.EMPTY);
        }
        // 非空，并验证 token 合法性
        return CharSequenceUtil.isNotBlank(token) && JWTUtil.verify(token, key.getBytes());
    }

}
