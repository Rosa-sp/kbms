package com.itlaobing.kms.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Classname DBHelper
 * @Description TODO()
 * @Date 2019/11/23 17:54
 * @Author by Alex
 */
public class DBHelper {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    //读取数据配置文件
    static{
        try {
            InputStream is = DBHelper.class.getResourceAsStream("/db.properties");
            Properties properties = new Properties();
            properties.load(is);
            DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("pass");
            Class.forName(DRIVER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("注意：数据库配置文件失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("注意：数据库驱动加载失败");
        }
    }
    /**
     * 连接数据库
     * @throws SQLException
     */
    private void createConnection() throws SQLException {
        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }
    }

    /**
     * 给pstmt预编译的参数赋值
     * @param values
     * @throws SQLException
     */
    private void setParamter(Object ...values) throws SQLException {
        if(values != null){
            for(int i = 0; i < values.length; i++){
                pstmt.setObject(i+1,values[i]);
            }
        }
    }

    /**
     *执行DQL语句
     * @param sql
     * @param values
     * @return  返回结果集
     * @throws SQLException
     */
    public ResultSet executeQuery(String sql, Object ...values) throws SQLException {
        createConnection();

        pstmt = conn.prepareStatement(sql);

        setParamter(values);

        return pstmt.executeQuery();
    }

    private void setP(Object ...values) throws SQLException {
        if(values != null){
            for(int i = 0; i < values.length; i++){
                pstmt.setObject(i+1,"%"+values[i]+"%");
            }
        }
    }

    public ResultSet query(String sql, Object ...values) throws SQLException {
        createConnection();

        pstmt = conn.prepareStatement(sql);

        setP(values);

        return pstmt.executeQuery();
    }
    /**
     * 执行DML语句
     * @param sql
     * @param values
     * @return 返回影响行数
     * @throws SQLException
     */

    public int executeUpdate(String sql,Object ...values) throws SQLException {

        createConnection();

        pstmt = conn.prepareStatement(sql);

        setParamter(values);

        return  pstmt.executeUpdate();

    }


    /**
     * 关闭资源
     * @throws SQLException
     */
    public void close() throws SQLException {
        if(conn != null){
            conn.close();
        }
        if(pstmt != null){
            pstmt.close();
        }
        if(rs != null){
            rs.close();
        }
    }


}
