package com.lahee.mutsa5thtobyspring3.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
   Connection makeConnection() throws ClassNotFoundException, SQLException;
}


