package com.bishe.mentality.controller;

import com.bishe.mentality.entity.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class TestController {

    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    // 跳转上传页面
    @RequestMapping("test")
    public String test() {
        return "Page";
    }

    // 执行上传活动封面
    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file,Model model) {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
        String path = filePath+"actPhoto/";
        // 新建文件
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将src路径发送至html页面
        model.addAttribute("filename", "~/assets/images/actPhoto/"+filename);
        return "admin/addAct";
    }



    @GetMapping("imagetest")
    public String imgtes1t(Model model){
        model.addAttribute("filename", "no");
        return "admin/addAct";
    }

}
