package org.jplus.service;

import org.jplus.pojo.UserDO;

public interface UserService {

    void insertUser(UserDO user);

    void deleteUser(Integer id);

    UserDO getUser(Integer id);

    void updateUser(UserDO user);
}
