package com.memberSystem.mapper;

import com.memberSystem.entity.memberLevel;
import com.memberSystem.entity.memberLevelCredential;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface memberLevelMapper {

    List<memberLevel> findAll(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    List<memberLevel> findByKey(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("keyWord") String keyWord);

    memberLevel memberLevelGet(Long memberId);

    Integer dataCounts(String keyWord);

    /*
    * 插入模块
    * */
//    传入会员等级数据
    @Insert("insert into member_system.member_level" +
            "(member_id,level_name, exp_demand_start,exp_demand_end, is_show, background, avatar, is_default, create_id,  update_id,  del_flag) " +
            "values(#{memberId},#{levelName}, #{expDemandStart},#{expDemandEnd}, #{isShow}, #{background}, #{avatar}, #{isDefault}, #{createId},  #{updateId},  #{delFlag});")
    Integer insert(memberLevel memberLevel);
//    m_c关联表进行连接（是上面的辅操作）
    @Insert("insert into member_system.member_level_m_c" +
            "(member_id,credential_id) " +
            "values(#{memberId},#{credentialId});")
    Integer insertMC(Long memberId,Integer credentialId);

    /*
    * 更新模块
    * */
    Integer update(memberLevel memberLevel);


    /*
    * 删除模块
    * */
//    删除member_Level
    @Delete("delete from member_system.member_level where member_id=#{memberId}")  @ResultType(String.class)
    Integer delete( Long memberId);
//    删除关联表m_c的关系
    @Delete("delete from member_system.member_level_m_c where member_id=#{memberId}")
    Integer deleteMC( Long memberId);
//    删除头像/背景的一条关联记录
//        1、先查出图片的url
//        2、删除member_file的一条url记录（一条背景对应一条记录，一条图标也对应一条记录）
    @Select("select avatar from member_level where member_id=#{memberId}") @ResultType(String.class)
    String findAvatar(Long memberId);
    @Select("select background from member_level where member_id=#{memberId}") @ResultType(String.class)
    String findBackground(Long memberId);
    @Delete("delete from `member_file` where id  in (select id from (SELECT id FROM `member_file` where url=#{url} limit 1) as B)")
    Integer deleteFile( String url);

}
