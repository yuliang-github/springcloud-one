package com.yl.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Alex
 * @since 2019/2/16 12:59
 */

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptNo;

    private String deptName;

    private String db_source; // 来自哪个数据库,微服务架构下,一个服务可以对应一个数据库,同一个信息可能被存储在多个数据库


    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptNo(1L);
        dept.setDeptName("");
    }

}
