package com.bishe.mentality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndextController {

    @GetMapping("/index")
    public String toindex(){
        return "index";
    }

    @GetMapping("/user/select")
    public String succ(){
        return "select";
    }

    @GetMapping("/toAdd")
    public String add(){
        return "addAdmin";
    }

    @GetMapping("/toAdminPage")
    public String toadm(){

        return "admin/index";
    }

    @GetMapping("toConsultantPage")
    public String toCons(){
        return "consultant/index";
    }

    @GetMapping("notlogin")
    public String notlogin(Model model){
        model.addAttribute("msg","用户名或密码错误，登录失败");
        return "index";
    }

    @GetMapping("/admin/user")
    public String userManager(){return "admin/userManager";}


    @GetMapping("/admin/useradd")
    public String addUser(){return "admin/addUser";}

    @GetMapping("/admin/queadd")
    public String addQue(){
        return "admin/addQues";
    }
    @GetMapping("/admin/Roomadd")
    public String roomadd(){
        return "admin/addRoom";
    }
}
