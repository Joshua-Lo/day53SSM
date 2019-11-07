package com.shan.service.impl;

import com.shan.dao.IUserDao;
import com.shan.domain.User;
import com.shan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
    userDao.updateUser(user);
    }

    @Override
    public void addUser(User user) {
    userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
    userDao.deleteUser(id);
    }
}
