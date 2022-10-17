package com.memberSystem.service.impl;

import com.memberSystem.entity.memberLevel;
import com.memberSystem.mapper.memberLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class memberLevelService {
    @Autowired
    private memberLevelMapper memberLevelMapper;

    public int save(memberLevel memberLevel){
        memberLevel.setCreateId(1);
        memberLevel.setUpdateId(1);
        memberLevel.setDelFlag(0);
        if (memberLevel.getMemberId()==null) {
            return memberLevelMapper.insert(memberLevel);
        }else {
            return memberLevelMapper.update(memberLevel);
        }
    }
    public List<memberLevel> find(Integer pageNum,Integer pageSize, String keyWord){
        if (keyWord.isEmpty()) {
            return memberLevelMapper.findAll(pageNum,pageSize);
        }else{
            return memberLevelMapper.findByKey(pageNum,pageSize,keyWord);
        }
    }

    public memberLevel memberLevelGet(Integer memberId){
        return  memberLevelMapper.memberLevelGet(memberId);
    }

    public Integer dataCounts(String keyWord){
        return memberLevelMapper.dataCounts(keyWord);
    }

    public Integer delete(Integer[] memberId){
        for (int id:
             memberId) {
            if (memberLevelMapper.delete(id)==0){
                return 0;
            }
        }
        return 1;
    }

}
