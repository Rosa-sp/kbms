package com.itlaobing.kms.dao;

import com.itlaobing.kms.models.TblTypeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Classname TblTypeDao
 * @Description TODO()
 * @Date 2019/11/23 18:06
 * @Author by Alex
 */
public class TblTypeDao {

    /**
     * 查询知识类别
     * @param id
     * @return
     * @throws SQLException
     */

    public TblTypeModel type(Integer id){
        DBHelper dbHelper = new DBHelper();

        String sql = "select typeName,typeDesc from tbl_type where id = ?";

        ResultSet rs = null;
        TblTypeModel model = null;
        try {
            rs = dbHelper.executeQuery(sql,id);
             if (rs.next()){
            model = mapper(rs);
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }finally {
            try {
                dbHelper.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return model;
    }

    /**
     * 通过ID查询类别名称
     * @param id
     * @return
     * @throws SQLException
     */

    public String typeName(Integer id) {
        DBHelper dbHelper = new DBHelper();

        String sql = "select typeName,typeDesc from tbl_type where id = ?";

        ResultSet rs = null;
        String name = null;
        try {
            rs = dbHelper.executeQuery(sql,id);
            if (rs.next()){
                name = rs.getString("typeName");
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        finally {
            try {
                dbHelper.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }


    private TblTypeModel mapper(ResultSet rs) throws SQLException {
        TblTypeModel model = new TblTypeModel();
        model.setTypeName(rs.getString("typeName"));
        model.setTypeDesc(rs.getString("typeDesc"));
        return model;
    }


}
