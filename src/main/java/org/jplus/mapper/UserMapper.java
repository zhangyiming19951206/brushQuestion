package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Repository
public interface UserMapper {

    void insertUser(UserDO user);

    void deleteUser(@Param("id") Integer id);

    UserDO getUser(@Param("id") Integer id);

    void updateUser(UserDO user);

}
