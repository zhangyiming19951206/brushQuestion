package org.jplus.pojo.yjsjyxm;

import lombok.Data;

/**
 * @description:研究生学科与研究生教育项目实体类
 * @author:zmj
 * @date 2019/11/815:45
 */

@Data
public class Yjsjyxm {
//教研项目id
    private Integer jyxmid;

//教研项目工号
    private String gh;

//教研项目年度
    private Integer nd;

//教研项目名称
    private String xmmc;

//项目等级编码
    private Integer xmdjbm;

//项目排名
    private Integer xmpm;

//项目总人数
    private Integer zrs;

//项目工作量
    private Float gzl;

}
