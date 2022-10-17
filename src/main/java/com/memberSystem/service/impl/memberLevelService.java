package com.memberSystem.service.impl;

import com.memberSystem.entity.memberLevel;
import com.memberSystem.entity.memberLevelCredential;
import com.memberSystem.mapper.memberLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class memberLevelService {
    @Autowired
    private memberLevelMapper memberLevelMapper;
//      增加或更新
    public int save(memberLevel memberLevel){
        memberLevel.setCreateId(1);
        memberLevel.setUpdateId(1);
        memberLevel.setDelFlag(0);
        if (memberLevel.getMemberId()==null) {
//            时间戳生成id
            memberLevel.setMemberId(System.currentTimeMillis());
//            m_c表连接数据
            for (memberLevelCredential memberLevelCredential:
                memberLevel.getMemberLevelCredentials()) {
                memberLevelMapper.insertMC(memberLevel.getMemberId(),memberLevelCredential.getCredentialId());
            }
//            会员等级表插入
            return memberLevelMapper.insert(memberLevel);
        }else {
            return memberLevelMapper.update(memberLevel);
        }
    }
//    查询或关键词查询
    public List<memberLevel> find(Integer pageNum,Integer pageSize, String keyWord){
        if (keyWord.isEmpty()) {
            return memberLevelMapper.findAll(pageNum,pageSize);
        }else{
            return memberLevelMapper.findByKey(pageNum,pageSize,keyWord);
        }
    }
//获取单个用户
    public memberLevel memberLevelGet(Integer memberId){
        return  memberLevelMapper.memberLevelGet(memberId);
    }
//获取数据总数
    public Integer dataCounts(String keyWord){
        return memberLevelMapper.dataCounts(keyWord);
    }

//    删除
    public Integer delete(Long[] memberId){
        int flag=0;
        for (long id:
             memberId) {
            if (memberLevelMapper.delete(id)==0){
                flag=1;
            }
        }
        return flag;
    }

}
