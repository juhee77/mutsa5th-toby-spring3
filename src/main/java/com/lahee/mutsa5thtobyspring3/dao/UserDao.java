package com.lahee.mutsa5thtobyspring3.dao;

import com.lahee.mutsa5thtobyspring3.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class UserDao {
    ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connection) {
        this.connectionMaker = connection;
    }


    public void add() throws ClassNotFoundException, SQLException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into user(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, String.valueOf(new Random().nextInt()));
        pstmt.setString(2, "test");
        pstmt.setString(3, "12345678");

        pstmt.executeUpdate();
        pstmt.close();
        conn.close();

    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection conn = connectionMaker.makeConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into user(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        pstmt.executeUpdate();
        pstmt.close();
        conn.close();

    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection con = connectionMaker.makeConnection();

        PreparedStatement pstm = con.prepareStatement("select * from user where id=?");
        pstm.setString(1, id);
        ResultSet rs = pstm.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

        rs.close();
        pstm.close();
        con.close();
        System.out.println(user);
        return user;
    }

    public void delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = connectionMaker.makeConnection();

        PreparedStatement pstm = con.prepareStatement("delete from user where id = ?");
        pstm.setString(1, id);
        pstm.executeUpdate();

        pstm.close();
        con.close();
        System.out.println(id+" delete");
    }

    // public abstract Connection getConnection() throws SQLException, ClassNotFoundException;

}
