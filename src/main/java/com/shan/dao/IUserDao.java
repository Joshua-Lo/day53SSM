package com.shan.dao;

import com.shan.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserDao {
    List<User> getList();

    User findById(Integer id);

    void updateUser(User user);

    void addUser(User user);

    void deleteUser(Integer id);
}
