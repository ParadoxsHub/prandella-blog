package com.github.paradoxshub.prandellablog.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface VersionMapper {

    /**
     * 获取数据库的当前时间
     * @return
     */
    Date now();
}
