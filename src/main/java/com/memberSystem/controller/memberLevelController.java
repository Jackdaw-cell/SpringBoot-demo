package com.memberSystem.controller;

import com.memberSystem.entity.memberLevel;
import com.memberSystem.mapper.memberLevelMapper;
import com.memberSystem.service.memberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
//@RequestMapping("/memberLevel")
public class memberLevelController {
    @Autowired
    private memberLevelService memberLevelService;

//    新增或更新
    @PostMapping("/memberLevel")
    public Integer save(@RequestBody memberLevel memberLevel){
        return memberLevelService.save(memberLevel);
    }

//    批量查询
    @GetMapping("/memberLevel")
    public Map<String, Object> find(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String keyWord){
        pageNum=(pageNum-1)*pageSize;
        Integer total=memberLevelService.dataCounts(keyWord);
        List<memberLevel> data= memberLevelService.find(pageNum,pageSize,keyWord);
        Map<String,Object> res=new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }

//    单条查询
    @GetMapping("/memberLevelGet")
    public memberLevel memberLevelGet(@RequestParam Integer memberId){
        return memberLevelService.memberLevelGet(memberId);
    }

//获取数据总数
    @GetMapping("/dataCounts")
    public Integer dataCounts(@RequestParam String keyWord){ return memberLevelService.dataCounts(keyWord); }

//    批量删除
    @DeleteMapping("/memberLevel")
    public Integer delete(@RequestParam Integer[] memberId){
        return memberLevelService.delete(memberId);
    }

}


//@RequestBody 把请求的json转为memberLevel
//@RequestParam 把请求数组转为List<Integer>