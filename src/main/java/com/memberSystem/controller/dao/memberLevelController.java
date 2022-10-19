package com.memberSystem.controller.dao;

import com.memberSystem.controller.fileController;
import com.memberSystem.entity.memberLevel;
import com.memberSystem.service.impl.memberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class memberLevelController {
    @Autowired
    private memberLevelService memberLevelService;

    @Autowired
    private fileController fileController;

//    新增或更新
    @PostMapping("/memberLevel")
    public Integer save(@RequestBody memberLevel memberLevel){
        return memberLevelService.save(memberLevel);
    }

//    批量查询
    @GetMapping("/memberLevel")
    public Map<String, Object> find(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String keyWord){
        pageNum=(pageNum-1)*pageSize;
        List<memberLevel> data= memberLevelService.find(pageNum,pageSize,keyWord);
        Integer total=dataCounts(keyWord);
        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }

    //获取数据总数
    public Integer dataCounts(@RequestParam String keyWord){ return memberLevelService.dataCounts(keyWord); }

//    单条查询
    @GetMapping("/memberLevelGet")
    public memberLevel memberLevelGet(@RequestParam Long memberId){
        return memberLevelService.memberLevelGet(memberId);
    }

//    批量删除
    @DeleteMapping("/memberLevel")
    public Integer delete(@RequestParam Long[] memberId){
        return memberLevelService.delete(memberId);
    }

}


//@RequestBody 把请求的json转为memberLevel
//@RequestParam 把请求数组转为List<Integer>