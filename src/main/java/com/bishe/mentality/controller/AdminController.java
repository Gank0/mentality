package com.bishe.mentality.controller;

import com.bishe.mentality.entity.*;
import com.bishe.mentality.service.AdminService;

import com.bishe.mentality.service.RecordService;
import com.bishe.mentality.service.StuService;
import com.bishe.mentality.service.TestqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private StuService stuService;

    @Autowired
    private TestqService testqService;

    @Autowired
    private RecordService recordService;

    @GetMapping("/findAllAdmin")
    public String findall(Model model, HttpSession httpSession){
        List<Admin> admins=adminService.findAllAdmin();
        model.addAttribute("admins",admins);
        model.addAttribute("uid",httpSession.getAttribute("uid"));
        return "select";
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin(Admin admin){
        adminService.saveAdmin(admin);
        return "redirect:/admin/findAllAdmin";
    }

    @GetMapping("/deleteAdmin")
    public String delete(String id){
        adminService.deleteAdmin(id);
        return "redirect:/admin/findAllAdmin";
    }

    @GetMapping("/findAdmin")
    public String findAdmin(String id,Model model){
        Admin admin=adminService.findAdmin(id);
        model.addAttribute("admin",admin);
        return "updateAdmin";
    }


    @PostMapping("/editAdmin")
    public String editAdmin(Admin admin){
        adminService.updateAdmin(admin);
        return "redirect:/admin/findAllAdmin";
    }

    @GetMapping("/StuList")
    public String findAllStu(Model model){
        List<Student> stulis=stuService.findAllStu();
        model.addAttribute("stus",stulis);
        return "admin/userManager";
    }
    @GetMapping("/QueList")
    public String findAllQue(Model model){
        List<Testquestion> ques= testqService.findAllQ();
        model.addAttribute("ques",ques);
        return "admin/questionList";
    }
    @GetMapping("/findQue")
    public String findQue(int Testno, Model model){
        Testquestion testquestion=testqService.findQByNo(Testno);
        model.addAttribute("testquestion",testquestion);
        return "admin/editQues";
    }
    @PostMapping("/editQue")
    public String editQue(Testquestion testquestion){
        testqService.updateQ(testquestion);
        return "redirect:/admin/QueList";
    }

    @GetMapping("/deleteQ")
    public String deleteQ(int Testno){
        System.out.println(Testno);
        System.out.println("111");
        testqService.deleteQByNo(Testno);
        return "redirect:/admin/QueList";
    }
    @PostMapping("/addQue")
    public String addQ(Testquestion testquestion){
        testqService.addQ(testquestion);
        return "redirect:/admin/QueList";
    }
    @GetMapping("/recordlist")
    public String rlist(Model model){
        List<Record> records=recordService.findAllRecord();
        model.addAttribute("records",records);
        return "admin/record";
    }
    @GetMapping("/detailTest")
    public String deTest(String s_no,Model model){
        List<Testquestion> testquestions = new LinkedList<>();
        Record record=recordService.findRecord(s_no);
        testquestions.add(testqService.findQByNo(record.getTestno1()));
        testquestions.add(testqService.findQByNo(record.getTestno2()));
        testquestions.add(testqService.findQByNo(record.getTestno3()));
        testquestions.add(testqService.findQByNo(record.getTestno4()));
        testquestions.add(testqService.findQByNo(record.getTestno5()));
        model.addAttribute("questions",testquestions);
        List<String> ans=new LinkedList<>();
        ans.add(record.getAnswer1());
        ans.add(record.getAnswer2());
        ans.add(record.getAnswer3());
        ans.add(record.getAnswer4());
        ans.add(record.getAnswer5());
        model.addAttribute("ans",ans);
        return "admin/detailTest";
    }
}
