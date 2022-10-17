package com.memberSystem.service.impl;

import com.memberSystem.entity.memberLevelCredential;
import com.memberSystem.mapper.memberLevelCredentialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class memberLevelCredentialService {
    @Autowired
    private com.memberSystem.mapper.memberLevelCredentialMapper memberLevelCredentialMapper;

    public int save(memberLevelCredential memberLevelCredential){
        memberLevelCredential.setCreateId(1);
        memberLevelCredential.setUpdateId(1);
        memberLevelCredential.setDelFlag('0');
        if (memberLevelCredential.getCredentialId()==null) {
            return memberLevelCredentialMapper.insert(memberLevelCredential);
        }else {
            return memberLevelCredentialMapper.update(memberLevelCredential);
        }
    }
    public List<memberLevelCredential> find(Integer pageNum,Integer pageSize, String keyWord){
        if (keyWord.isEmpty()) {
            return memberLevelCredentialMapper.findAll(pageNum,pageSize);
        }else{
            return memberLevelCredentialMapper.findByKey(pageNum,pageSize,keyWord);
        }
    }

    public memberLevelCredential memberLevelCredentialGet(Integer memberId){
        return  memberLevelCredentialMapper.memberLevelCredentialGet(memberId);
    }

    public Integer dataCounts(String keyWord){
        return memberLevelCredentialMapper.dataCounts(keyWord);
    }

    public Integer delete(Integer[] memberId){
        for (int id:
             memberId) {
            if (memberLevelCredentialMapper.delete(id)==0){
                return 0;
            }
        }
        return 1;
    }

}
