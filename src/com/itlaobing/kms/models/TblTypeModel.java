package com.itlaobing.kms.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname TblTypeModel
 * @Description TODO()
 * @Date 2019/11/23 17:47
 * @Author by Alex
 */
@Data
@NoArgsConstructor
public class TblTypeModel {
    private int id;
    private String typeName;
    private String typeDesc;
}
