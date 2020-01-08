package com.offcn.user.service;

import com.offcn.user.bean.User;
import com.offcn.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao ud;

    @Override
    public void saveUser(User user) {
        ud.save(user);
    }

    @Override
    public void delUser(Integer id) {
        ud.deleteById(id);
    }

    @Override
    public void updUser(User user) {
        ud.saveAndFlush(user);
    }

    @Override
    public User findUser(Integer id) {
        Optional<User> user = ud.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> findUsers() {
        List<User> userList = ud.findAll();
        return userList;
    }
}
