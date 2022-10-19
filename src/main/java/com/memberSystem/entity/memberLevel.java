package com.memberSystem.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class memberLevel {
    private Long memberId;
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

//    private MultipartFile avatarFile;
//    public MultipartFile getAvatarFile() {
//        return avatarFile;
//    }
//
//    public void setAvatarFile(MultipartFile avatarFile) {
//        this.avatarFile = avatarFile;
//    }
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

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
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
