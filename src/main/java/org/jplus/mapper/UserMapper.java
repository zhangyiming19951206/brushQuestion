package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.Users;
import org.springframework.stereotype.Component;

/**
 * @author imlgw.top
 * @date 2019/10/31 17:25
 */
@Component
public interface UserMapper {

    @Select("SELECT * FROM users WHERE gh=#{gh}")
    Users getById(@Param("gh") String gh);

    @Update("update users set upassword=#{upassword} where gh=#{gh}")
    void update(@Param("upassword")String upassword,@Param("gh") String gh);
}
