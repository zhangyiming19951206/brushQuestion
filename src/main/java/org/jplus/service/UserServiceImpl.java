package org.jplus.service;

import org.jplus.mapper.UserMapper;
import org.jplus.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(UserDO user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public UserDO getUser(Integer id) {
        return userMapper.getUser(id);
    }

    @Override
    public void updateUser(UserDO user) {
        userMapper.updateUser(user);
    }
}
