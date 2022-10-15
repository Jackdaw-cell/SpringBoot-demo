package com.memberSystem.mapper;

import com.memberSystem.entity.memberLevelCredential;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface memberLevelCredentialMapper {

    List<memberLevelCredential> findAll(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    List<memberLevelCredential> findByKey(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("keyWord") String keyWord);

    memberLevelCredential memberLevelCredentialGet(Integer credentialId);

    Integer dataCounts(String keyWord);

    @Insert("insert into member_system.member_level_credentials" +
            "(credential_id,avatar,credentials_name,credentials_statement.is_vip,is_show,create_id,update_id) " +
            "values(#{credentialId},#{avatar},#{credentialsName},#{credentialsStatement},#{isVip},#{isShow}, #{createId}, #{updateId});")
    Integer insert(memberLevelCredential memberLevelCredential);

    Integer update(memberLevelCredential memberLevelCredential);

    @Delete("delete from member_system.member_level_credentials where credential_id=#{credentialId}")
    Integer delete( Integer credentialId);


}
