package com.github.paradoxshub.prandellablog;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.entity.Version;
import com.github.paradoxshub.prandellablog.mappers.UserMapper;
import com.github.paradoxshub.prandellablog.mappers.VersionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@SpringBootTest(classes = PrandellaBlogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyBatisTests {

    private final Logger logger = Logger.getLogger(MyBatisTests.class.getName());

    @Autowired
    private VersionMapper versionMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        System.out.println(("----- insert method test ------"));
        Date result = versionMapper.now();
        logger.info(result.toString());
        Date now = new Date();
        logger.info(now.toString());
        Assert.isTrue(!now.after(result), "select now() failed");
    }

    @Test
    public void testInsertUser() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername("hello");
        user.setPassword("hello");
        user.setEmail("1243@dkk.com");
        user.setNickname("hello");
        user.setCreated_at(Timestamp.from(Instant.now()));
        user.setUpdated_at(Timestamp.from(Instant.now()));
        user.setCreated_by(123L);
        user.setUpdated_by(456L);

        Long userId = userMapper.insertUser(user);
        Assert.notNull(userId, "insert user failed");
    }

}