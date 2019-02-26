package com.sxt.sys.controller;

import com.sxt.sys.utils.RandomUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WanMing
 * @date 2019/2/26 14:44
 */

@Controller
@RequestMapping("file")
public class UploadController {

    @Value("${upload.rootPath}")
    private String rootPath;

    /**
     * 图片上传
     * @param mf
     * @return
     */
    @RequestMapping("uploadFile")
    @ResponseBody
    public Map<String,Object> uploadFile(MultipartFile mf){
        //创建文件夹
        String dirName = RandomUtils.createDirUseTime();
        File dirFile = new File(rootPath+dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //构建文件路劲
        String newName = RandomUtils.createFileNameUseTime(mf.getOriginalFilename());
        File file = new File(rootPath,dirName+"/"+newName);
        Integer code = 0;
        try {
            mf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            code = -1;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg","");
        Map<String,Object> data = new HashMap<>();
        data.put("src",dirName+"/"+newName);
        map.put("data",data);
        return map;
    }

    /**
     * 文件下载
     * @param goodsimg
     * @return
     */
    @RequestMapping("downloadFile")
    @ResponseBody
    public ResponseEntity<Object> downLoadFile(String goodsimg){
        // 得到文件的绝对路径
        String realPath = rootPath + goodsimg;
        // 构造文件对象
        File file = new File(realPath);

        // 将下载的文件，封装byte[]
        byte[] bytes = null;
        try {
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 创建封装响应头信息的对象
        HttpHeaders header = new HttpHeaders();
        // 封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载的文件的名称
        header.setContentDispositionFormData("attachment", "123.jpg");

        // 创建ResponseEntity对象
        ResponseEntity<Object> entity = new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);

        return entity;
    }
}
