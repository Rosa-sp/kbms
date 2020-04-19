package com.itlaobing.kms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Classname TblFromDao
 * @Description TODO()
 * @Date 2019/11/24 13:57
 * @Author by Alex
 */
public class TblFromDao {
    /**
     * 根据ID查询知识来源
     * @param id
     * @return
     * @throws SQLException
     */

    public String from(Integer id){
        DBHelper dbHelper = new DBHelper();

        String sql = "select fromName from tbl_from where id = ?";

        ResultSet rs = null;
        String fromName = null;
        try {
            rs = dbHelper.executeQuery(sql, id);

        if (rs.next()){
            fromName = rs.getString("fromName");
        }
         }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                dbHelper.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fromName;
    }
}
