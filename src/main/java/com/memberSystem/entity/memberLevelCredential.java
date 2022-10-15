package com.memberSystem.entity;

import org.springframework.stereotype.Component;

@Component
public class memberLevelCredential {
    Integer credentialId;
    String avatar;
    String credentialsName;
    String credentialsStatement;
    char isShow;
    Integer isVip;
    Integer createId;
    String createTime;
    Integer updateId;
    String updateTime;
    char delFlag;
    String levelName;

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public memberLevelCredential(Integer credentialId, String avatar, String credentialsName, String credentialsStatement, char isShow, Integer createId, String createTime, Integer updateId, String updateTime, char delFlag) {
        this.credentialId = credentialId;
        this.avatar = avatar;
        this.credentialsName = credentialsName;
        this.credentialsStatement = credentialsStatement;
        this.isShow = isShow;
        this.createId = createId;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public memberLevelCredential() {
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCredentialsName() {
        return credentialsName;
    }

    public void setCredentialsName(String credentialsName) {
        this.credentialsName = credentialsName;
    }

    public String getCredentialsStatement() {
        return credentialsStatement;
    }

    public void setCredentialsStatement(String credentialsStatement) {
        this.credentialsStatement = credentialsStatement;
    }

    public char getIsShow() {
        return isShow;
    }

    public void setIsShow(char isShow) {
        this.isShow = isShow;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public char getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(char delFlag) {
        this.delFlag = delFlag;
    }

}
