package com.shan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shan.domain.Msg;
import com.shan.domain.User;
import com.shan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/user")
    public Msg getListWithJson(Integer pageNo){
        PageHelper.startPage(pageNo,8);
        List<User> userList = userService.getList();
        PageInfo pageInfo = new PageInfo(userList, 5);

        return Msg.sucess().add("pageInfo",pageInfo);
    }
}
