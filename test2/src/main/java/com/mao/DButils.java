package com.mao;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButils {
    public static DataSource dataSource = null;
    static {
        try {
            Properties properties = new Properties();
            //方式一出现FileNotFoundException
            //inputStream = new FileInputStream("resources/jdbc.properties");
            //方式二
             InputStream inputStream = DButils.class.getClassLoader().getResourceAsStream("db.properties");
//           InputStream inputStream = new FileInputStream("resources/db.properties");
            System.out.println(inputStream);
            properties.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获得连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //关闭连接
    public void close(Statement st, Connection conn, ResultSet res){
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(res!=null) {
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
