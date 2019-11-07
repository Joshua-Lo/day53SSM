package com.shan;

import com.shan.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ctx.getBean("accountService", AccountService.class);
        accountService.findAll();
    }
}
