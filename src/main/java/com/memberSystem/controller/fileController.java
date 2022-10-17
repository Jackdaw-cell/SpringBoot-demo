package com.memberSystem.controller;

//文件上传接口


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.memberSystem.entity.Files;
import com.memberSystem.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.FileStore;
import java.util.List;

/*
* 文件上传
* */
@RestController
@RequestMapping("/file")
public class fileController {

//    上传路径前缀
    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Autowired
    private FileMapper fileMapper;

//    上传功能
//    springboot有工具类MultipartFile可以接收文件参数
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originFilename=file.getOriginalFilename();
        String type= FileUtil.extName(originFilename);
        long size=file.getSize();

//        定义文件唯一标识码以及类型后缀
        String uuid= IdUtil.fastSimpleUUID();
        String fileUUID=uuid+StrUtil.DOT+type;
        File uploadFile = new File(fileUploadPath+fileUUID);
        File parentFile=uploadFile.getParentFile();
//        判断存储文件夹是否存在，不存在则创建
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

//        获取文件md5+判断文件是否存在
//        目的：节省空间，重复的文件不再上传；md5可以判断文件之间内容是否相同
//        根据md5查询files文件
//        QueryWrapper为mybatis-plus提供的集合类型，可以用于查询数据库数据
//        数据库设置md5为unique保证唯一性
//        如果文件存在，则判断md5是否存在，如果md5存在，则不创建文件，仅返回文件的url；
//                                    如果md5不存在，则创建文件并且返回url
//        如果文件不存在，则创建文件并创建md5
//        String md5;
//        String url;
//        if (uploadFile.exists()) {
//            md5= SecureUtil.md5(uploadFile);
//            Files dbFiles=getFileMd5(md5);
////        获取文件url
//            if (dbFiles != null) {
//                url=dbFiles.getUrl();
//            }else {
//                file.transferTo(uploadFile);
//                url="http://localhost:9090/file/"+fileUUID;
//            }
//        }else{
////        文件存储到磁盘
//            file.transferTo(uploadFile);
//            md5=SecureUtil.md5(uploadFile);
//            url="http://localhost:9090/file/"+fileUUID;
//        }


//        实际情况下有可能多个人使用相同的头像，这样既要保证多个用户指向相同图片，又要节省空间
//        相比上面，服务器可以实现多个用户信息指向相同的照片文件，数据库可以存在多条md5，但是照片文件只能存在一个
//        相比上面，数据库移除md5的unique索引
        String url;
        file.transferTo(uploadFile);
        String md5= SecureUtil.md5(uploadFile);
        Files dbFiles=getFileMd5(md5);
//        获取文件url
            if (dbFiles != null) {
                url=dbFiles.getUrl();
                uploadFile.delete();
            }else {
                url="http://localhost:9090/file/"+fileUUID;
            }

//        存储数据库
//        用了mybatis-plus,方法自动生成的
        Files saveFiles = new Files();
        saveFiles.setName(originFilename);
        saveFiles.setType(type);
        saveFiles.setSize(size/1024);
        saveFiles.setUrl(url);
        saveFiles.setMd5(md5);
        fileMapper.insert(saveFiles);
        return url;
    }

//    下载文件
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
//        根据唯一标识获取文件
        File uploadFile=new File(fileUploadPath+fileUUID);
//        规定输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");

        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }

//    通过md5查询文件
    private Files getFileMd5(String md5){
//        查询文件md5是否存在
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<Files> filesList = fileMapper.selectList(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }
}
