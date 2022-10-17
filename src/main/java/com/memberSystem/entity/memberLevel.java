package com.memberSystem.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class memberLevel {
    private Integer memberId;
    private String levelName;
    private String expDemandStart;
    private String expDemandEnd;
    private char isShow;
    private String background;
    private String avatar;
    private char isDefault;
    private Integer createId;
    private String createTime;
    private Integer updateId;
    private String updateTime;
    private Integer delFlag;

//    权益集合
    private List<memberLevelCredential> memberLevelCredentials;

    public List<memberLevelCredential> getMemberLevelCredentials() {
        return memberLevelCredentials;
    }

    public void setMemberLevelCredentials(List<memberLevelCredential> memberLevelCredentials) {
        this.memberLevelCredentials = memberLevelCredentials;
    }

    public String getExpDemandStart() {
        return expDemandStart;
    }

    public void setExpDemandStart(String expDemandStart) {
        this.expDemandStart = expDemandStart;
    }

    public String getExpDemandEnd() {
        return expDemandEnd;
    }

    public void setExpDemandEnd(String expDemandEnd) {
        this.expDemandEnd = expDemandEnd;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public memberLevel(Integer memberId, String levelName, String expDemandStart, String expDemandEnd, char isShow, String background, String avatar, char isDefault, Integer createId, String createTime, Integer updateId, String updateTime, Integer delFlag) {
        this.memberId = memberId;
        this.levelName = levelName;
        this.expDemandStart = expDemandStart;
        this.expDemandEnd = expDemandEnd;
        this.isShow = isShow;
        this.background = background;
        this.avatar = avatar;
        this.isDefault = isDefault;
        this.createId = createId;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public char getIsShow() {
        return isShow;
    }

    public void setIsShow(char isShow) {
        this.isShow = isShow;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public char getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(char isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public memberLevel() {
    }

}
