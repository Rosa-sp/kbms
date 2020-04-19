package com.itlaobing.kms.dao;

import com.itlaobing.kms.models.TblKnowledgeModel;
import com.itlaobing.kms.services.TblKnowledgeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname TblKnowledgeDao
 * @Description TODO()
 * @Date 2019/11/24 15:04
 * @Author by Alex
 */
public class TblKnowledgeDao {

    /**
     * 添加知识
     * @param model
     * @return
     * @throws SQLException
     */
    public int save(TblKnowledgeModel model)  {
        DBHelper dbHelper = new DBHelper();
        int key = 0;
        String sql = "insert into tbl_knowledge(title,content,isPublish,fromName,typeld) values(?,?,?,?,?)";
        Object[] values = {
                model.getTitle(),
                model.getContent(),
                model.getIsPublish(),
                model.getFromName(),
                model.getTypeld()
        };
        try {
            key = dbHelper.executeUpdate(sql,values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    /**
     * 查询所有
     * @return
     */
    public List<TblKnowledgeModel> findAll(){
        DBHelper dbHelper = new DBHelper();

        String sql ="select * from tbl_knowledge";

        List<TblKnowledgeModel> list = new ArrayList<TblKnowledgeModel>();

        try {
            ResultSet rs = dbHelper.executeQuery(sql);

            while (rs.next()){
                list.add(mapper(rs));
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
        return list;

    }

    /**
     * 模糊查询
     * @param str
     * @return
     */

    public List<TblKnowledgeModel> likeFind(String str){
        DBHelper dbHelper = new DBHelper();

        String sql = "select * from tbl_knowledge where title like ?";

        TblKnowledgeModel model = new TblKnowledgeModel();

        List<TblKnowledgeModel> list = new ArrayList<TblKnowledgeModel>();

        try {
            ResultSet rs =  dbHelper.query(sql,str);
            while (rs.next()){
                list.add(mapper(rs)) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

}

    /**
     * 通过ID查询知识
     * @param id
     * @return
     * @throws SQLException
     */
    public TblKnowledgeModel findById(Integer id){
        DBHelper dbHelper = new DBHelper();
        String sql ="select * from tbl_knowledge where id = ?";
        TblKnowledgeModel model = new TblKnowledgeModel();
        try {
            ResultSet rs = dbHelper.executeQuery(sql,id);
            if (rs.next()){
                model = mapper(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    /**
     * 修改数据
     * @param model
     * @return
     * @throws SQLException
     */
    public int update(TblKnowledgeModel model){
        DBHelper dbHelper = new DBHelper();
        int key = 0;
        String sql="update tbl_knowledge set content=?,isPublish=?,fromName=?,title=?,createDate=? where id=?";

        Object[] values = {
                model.getContent(),
                model.getIsPublish(),
                model.getFromName(),
                model.getTitle(),
                model.getCreateDate(),
                model.getId()
        };
        try {
            key = dbHelper.executeUpdate(sql,values);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                dbHelper.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return key;
    }



    /**
     * 删除数据
     * @param id
     * @return
     * @throws SQLException
     */
    public int delete(Integer id){
        DBHelper dbHelper = new DBHelper();

        String sql = "delete from tbl_knowledge where id = ?";
        int x  = 0;
        try {
            x = dbHelper.executeUpdate(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                dbHelper.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return x;
    }

    public Map count(){
        DBHelper dbHelper = new DBHelper();
        String sql = "select typeld,count(*) from tbl_knowledge group by typeld";
        Map map = new HashMap();
        TblKnowledgeModel model = new TblKnowledgeModel();
        try {
            ResultSet rs =  dbHelper.executeQuery(sql);
            while (rs.next()){
                model = m(rs);
                map.put(model.getTypeld(),model.getCount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
    private TblKnowledgeModel m(ResultSet rs) throws SQLException {
        TblKnowledgeModel model = new TblKnowledgeModel();
        model.setCount(rs.getInt("count(*)"));
        model.setTypeld(rs.getInt("typeld"));
        return model;
    }

    private TblKnowledgeModel mapper(ResultSet rs) throws SQLException {
        TblKnowledgeModel model = new TblKnowledgeModel();
        model.setContent(rs.getString("content"));
        model.setIsPublish(rs.getInt("isPublish"));
        model.setFromName(rs.getString("fromName"));
        model.setTitle(rs.getString("title"));
        model.setCreateDate(rs.getDate("createDate"));
        model.setId(rs.getInt("id"));
        model.setTypeld(rs.getInt("typeld"));
        return model;
    }
}
