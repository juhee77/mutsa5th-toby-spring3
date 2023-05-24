package com.lahee.mutsa5thtobyspring3.dao;

import com.lahee.mutsa5thtobyspring3.domain.User;

import java.sql.SQLException;

class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new NUserDao();
        String keyNum = "1223";
        userDao.add(new User(keyNum,"lahee","hello"));
        userDao.get(keyNum);
    }

}