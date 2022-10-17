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

    memberLevel memberLevelGet(Integer memberId);

    Integer dataCounts(String keyWord);

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

    Integer update(memberLevel memberLevel);

    @Delete("delete from member_system.member_level where member_id=#{memberId}")
    Integer delete( Long memberId);
}
