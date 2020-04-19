package com.itlaobing.kms.models;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TblKnowledgeModel
 * @Description TODO()
 * @Date 2019/11/23 17:50
 * @Author by Alex
 */
@Data
public class TblKnowledgeModel {
    private int id;
    private String title;
    private String content;
    private Date createDate;
    private int isPublish;
    private String fromName;
    private int typeld;
    private int count;
}
