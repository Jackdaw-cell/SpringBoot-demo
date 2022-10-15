package com.memberSystem.controller;

import com.memberSystem.entity.memberLevel;
import com.memberSystem.entity.memberLevelCredential;
import com.memberSystem.service.memberLevelCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
//@RequestMapping("/memberLevel")
public class memberLevelCredentialController {
    @Autowired
    private memberLevelCredentialService memberLevelCredentialService;

//    新增或更新
    @PostMapping("/memberLevelCredential")
    public Integer save(@RequestBody memberLevelCredential memberLevelCredential){
         return memberLevelCredentialService.save(memberLevelCredential);
    }

//    批量查询
    @GetMapping("/memberLevelCredential")
    public Map<String, Object> find(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String keyWord){
        pageNum=(pageNum-1)*pageSize;
        Integer total=memberLevelCredentialService.dataCounts(keyWord);
        List<memberLevelCredential> data= memberLevelCredentialService.find(pageNum,pageSize,keyWord);
        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }

//    单条查询
    @GetMapping("/memberLevelCredentialGet")
    public memberLevelCredential memberLevelGet(@RequestParam Integer memberId){
        return memberLevelCredentialService.memberLevelCredentialGet(memberId);
    }

//获取数据总数
    @GetMapping("/memberLevelCredentialDataCounts")
    public Integer dataCounts(@RequestParam String keyWord){ return memberLevelCredentialService.dataCounts(keyWord); }

//    批量删除
    @DeleteMapping("/memberLevelCredential")
    public Integer delete(@RequestParam Integer[] credentialId){
        return memberLevelCredentialService.delete(credentialId);
    }

}


//@RequestBody 把请求的json转为memberLevel
//@RequestParam 把请求数组转为List<Integer>