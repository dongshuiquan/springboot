package com.dsq.transation.mapper;

import com.dsq.transation.entity.User1;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DELL on 2018/12/13.
 */

@Repository
public interface User1Mapper {
    @Insert("insert into user1 values(#{id}, #{name})")
    int insert(User1 record);

    @Select("select * from user1 where id = #{id}")
    User1 selectByPrimaryKey(Integer id);

    @Delete("DELETE FROM user1")
    void delete();

}
