package com.mao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbcpTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet res =null;


        try {
            conn = DButils.getConnection();
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("select  * from article");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+" "+resultSet.getString("htmlContent"));
            }
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
