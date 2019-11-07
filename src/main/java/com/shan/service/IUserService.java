package com.shan.service;

import com.shan.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    List<User> getList();

    User findById(Integer id);

    void updateUser(User user);

    void addUser(User user);

    void deleteUser(Integer id);
}
