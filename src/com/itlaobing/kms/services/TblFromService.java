package com.itlaobing.kms.services;

import com.itlaobing.kms.dao.TblFromDao;

/**
 * @Classname TblFromService
 * @Description TODO()
 * @Date 2019/11/24 16:08
 * @Author by Alex
 */
public class TblFromService {
    private TblFromDao dao = new TblFromDao();
    /**
     * 查询知识来源
     * @param id
     * @return
     */
    public String from (Integer id){
        return dao.from(id);
    }
}
