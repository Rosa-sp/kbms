package com.itlaobing.kms.services;

import com.itlaobing.kms.dao.TblKnowledgeDao;
import com.itlaobing.kms.models.TblKnowledgeModel;

import java.util.List;
import java.util.Map;

/**
 * @Classname TblKnowledgeService
 * @Description TODO()
 * @Date 2019/11/24 16:11
 * @Author by Alex
 */
public class TblKnowledgeService {

    private TblKnowledgeDao dao = new TblKnowledgeDao();

    /**
     * 添加知识
     * @param model
     * @return
     */
    public int add(TblKnowledgeModel model){
        return dao.save(model);
    }

    /**
     * 修改知识
     * @param model
     * @return
     */
    public int update(TblKnowledgeModel model){
        return dao.update(model);
    }

    /**
     * 查询全部知识
     * @return
     */
    public List<TblKnowledgeModel> findAll(){
        return dao.findAll();
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    public int delete(Integer id){
        return dao.delete(id);
    }

    public TblKnowledgeModel findById(Integer id){
        return dao.findById(id);
    }

    public Map count(){
        return dao.count();
    }

    public List<TblKnowledgeModel> likeFind(String str){
        return dao.likeFind(str);
    }

    public boolean flag(String[] str,String s){
        for(int i = 0; i < str.length;i++){
            if(str[i].equals(s)){
                return true;
            }
        }
        return false;
    }

}
