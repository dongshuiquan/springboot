package com.dsq.transation.mapper;

import com.dsq.transation.entity.User1;
import com.dsq.transation.entity.User2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 2018/12/13.
 */
@Repository
public interface User2Mapper {
    @Insert("insert into user2 values(#{id}, #{name})")
    int insert(User2 record);

    @Select("select * from user2 where id = #{id}")
    User2 selectByPrimaryKey(Integer id);

    @Delete("DELETE FROM user2")
    void delete();

}
