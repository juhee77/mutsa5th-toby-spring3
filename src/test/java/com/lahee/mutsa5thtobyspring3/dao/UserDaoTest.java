package com.lahee.mutsa5thtobyspring3.dao;

import java.sql.SQLException;

class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new NUserDao();
        userDao.add();
        userDao.get(1);
    }

}