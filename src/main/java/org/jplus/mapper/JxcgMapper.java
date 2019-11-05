package org.jplus.mapper;

import org.apache.ibatis.annotations.*;
import org.jplus.pojo.teachingresearchInfo.*;

import java.util.List;

/**
 * @description: 教学成就mapper接口
 * @author:zmj
 * @date 2019/10/3116:35
 */
@Mapper
public interface JxcgMapper {
// ---------------------------教学成果-------------------------
//获取教学成果信息
    @Select("select * from jxcg")
     List<Jxcg> getJxcg();

//添加教学成果信息
    @Insert("insert into jxcg values(null,#{gh},#{nd},#{cgmc},#{cgdjbm},#{xmpm},#{jxcgzrs},#{jxcggzl})")
      int addJxcg(Jxcg jxcg);

//删除教学成果信息
    @Delete("delete from jxcg where jxcgid=#{id}")
     int deleteJxcg(Integer id);

//查询成果等级信息
    @Select("select * from jxcgdj")
    List<Jxcgdj> getJxcgdjInfo();

//根据等级编码查工作量
    @Select("select gdgzl from jxcgdj where cgdjbm = #{id}")
    int getGdgzl(Integer id);

//获取工作量总和
    @Select("select coalesce(sum(jxcggzl),0) jxcggzlsum from jxcg where gh = (#{gh})")
    float getJxcgGzlSun(String gh);

//------------------------------纵向项目------------------------------------
//获取纵向教研项目信息
    @Select("select * from zxxm")
    List<Zxxm> getZxxm();

    //添加纵向项目信息
    @Insert("insert into zxxm values(null,#{gh},#{nd},#{xmmc},#{xmdjbm},#{xmpm},#{xmzrs},#{zxxmgzl})")
    int addZxxm(Zxxm zxxm);

    //删除纵向项目信息
    @Delete("delete from zxxm where zxxmid=#{id}")
    int deleteZxxm(Integer id);

    //查询纵向项目等级信息
    @Select("select * from zxxmdj")
    List<Zxxmdj> getZxxmdjInfo();

    //根据等级编码查工作量
    @Select("select gdgzl from zxxmdj where xmdjbm = #{id}")
    int getZxxmgzl(Integer id);

    //获取工作量总和
    @Select("select coalesce(sum(zxxmgzl),0) zxxmgzlsum from zxxm where gh = (#{gh})")
    float getZxxmGzlSun(String gh);

//---------------------------------横向项目------------------------------------------
//获取横向项目信息
    @Select("select * from hxxm")
    List<Hxxm> getHxxm();

    //添加横向项目信息
    @Insert("insert into hxxm values(null,#{gh},#{nd},#{xmmc},#{dzjf},#{xmpm},#{xmzrs},#{hxgzl})")
    int addHxxm(Hxxm hxxm);


    //删除横向项目信息
    @Delete("delete from hxxm where hxxmid=#{id}")
    int deleteHxxm(Integer id);

    //获取工作量总和
    @Select("select coalesce(sum(hxgzl),0) hxgzlsum from hxxm where gh = (#{gh})")
    float getHxxmGzlSun(String gh);

//-------------------------------------教材-------------------------------------------
//获取教材信息
    @Select("select * from jc")
    List<Jc> getJc();

    //添加教材信息
    @Insert("insert into jc values(null,#{gh},#{nd},#{jcmc},#{jcjbbm},#{xmpm},#{xmzrs},#{jcgzl})")
    int addJc(Jc jc);

    //删除教材信息
    @Delete("delete from jc where jcid=#{id}")
    int deleteJc(Integer id);

    //查询教材级别信息
    @Select("select * from jcjb")
    List<Jcjb> getJcjbInfo();

    //根据等级编码查工作量
    @Select("select gdgzl from jcjb where jcjbbm = #{id}")
    int getJcGdgzl(Integer id);

    //获取工作量总和
    @Select("select coalesce(sum(jcgzl),0) jcgzlsum from jc where gh = (#{gh})")
    float getJcGzlSun(String gh);

// ---------------------------------------教学改革--------------------------------------------
//获取教学改革信息
    @Select("select * from jxgg")
    List<Jxgg> getJxgg();

    //添加教学改革信息
    @Insert("insert into jxgg values(null,#{gh},#{nd},#{xmmc},#{lxjbbm},#{xmpm},#{jxggzrs},#{jxgggzl})")
    int addJxgg(Jxgg jxgg);

    //删除教学改革信息
    @Delete("delete from jxgg where jxggid=#{id}")
    int deleteJxgg(Integer id);

    //查询立项级别信息
    @Select("select * from lxjb")
    List<Lxjb> getLxjbInfo();

    //根据等级编码查工作量
    @Select("select gdgzl from lxjb where lxjbbm = #{id}")
    int getLxjbGdgzl(Integer id);

    //获取工作量总和
    @Select("select coalesce(sum(jxgggzl),0) jxgggzlsum from jxgg where gh = (#{gh})")
    float getJxggGzlSun(String gh);
}