package com.github.paradoxshub.prandellablog;

import com.github.paradoxshub.prandellablog.entity.Version;
import com.github.paradoxshub.prandellablog.mappers.VersionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

@SpringBootTest(classes = PrandellaBlogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyBatisTests {

    private final Logger logger = Logger.getLogger(MyBatisTests.class.getName());

    @Autowired
    private VersionMapper versionMapper;

    @Test
    public void testInsert() {
        System.out.println(("----- insert method test ------"));
        Date result = versionMapper.now();
        logger.info(result.toString());
        Date now = new Date();
        logger.info(now.toString());
        Assert.isTrue(!now.after(result), "select now() failed");
    }

}