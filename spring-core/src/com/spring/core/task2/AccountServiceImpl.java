package com.spring.core.task2;

public class AccountServiceImpl implements  AccountService {

    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getSavePerson(String name) {
        System.out.println("AccountServiceImpl save to PersonService ");
        userService.save(name);
    }
}
