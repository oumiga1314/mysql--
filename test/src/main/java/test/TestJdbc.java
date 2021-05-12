package test;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestJdbc {

    public static void main(String[] args) throws Exception {
        f();
    }
    public static void f() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://127.0.0.1:3306/blog?user=root&password=123456&useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false";
        Connection connection = null;
        connection = DriverManager.getConnection(url);
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("select * from article");

        while (resultSet.next()){
            System.out.println(resultSet.getInt("id")+" "+resultSet.getString("htmlContent"));
        }
    }



}
