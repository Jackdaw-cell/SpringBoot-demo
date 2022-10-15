package com.memberSystem.mapper;

import com.memberSystem.entity.memberLevel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface memberLevelMapper {
//    @Select("SELECT * FROM member_system.member_level")
    List<memberLevel> findAll(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    List<memberLevel> findByKey(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("keyWord") String keyWord);

    memberLevel memberLevelGet(Integer memberId);

    Integer dataCounts(String keyWord);

    @Insert("insert into member_system.member_level" +
            "(level_name, exp_demand_start,exp_demand_end, is_show, background, avatar, is_default, create_id,  update_id,  del_flag) " +
            "values(#{levelName}, #{expDemandStart},#{expDemandEnd}, #{isShow}, #{background}, #{avatar}, #{isDefault}, #{createId},  #{updateId},  #{delFlag});")
    Integer insert(memberLevel memberLevel);

    Integer update(memberLevel memberLevel);

    @Delete("delete from member_system.member_level where member_id=#{memberId}")
    Integer delete( Integer memberId);


}
