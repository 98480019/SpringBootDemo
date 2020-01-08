package com.offcn.user.service;

import com.offcn.user.bean.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public void delUser(Integer id);

    public void updUser(User user);

    public User findUser(Integer id);

    public List<User> findUsers();
}
