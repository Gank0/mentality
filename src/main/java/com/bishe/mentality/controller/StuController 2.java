package com.bishe.mentality.controller;

import com.bishe.mentality.entity.*;
import com.bishe.mentality.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class StuController {
    @Autowired
    private StuService stuService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private TestqService testqService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private AttActService attActService;
    @Autowired
    private ActService actService;

    @PostMapping("/register")
    public String register(Student student){
        stuService.register(student);
        return "redirect:/index";
    }

    @PostMapping("/login")
    public String login(String no, String password, String role, HttpSession httpSession){
        try{
            if(role.equals("user")){
                Student stu=stuService.login(no,password);
                if(stu!=null){
                    httpSession.setAttribute("uid",no);
                    return "user/index";
                }
                else{
                    return "redirect:/notlogin";
                }
            }
            else if(role.equals("admin")){
                Admin adm=adminService.loginAdmin(no,password);
                if(adm!=null){
                    httpSession.setAttribute("uid",no);
                    return "redirect:/toAdminPage";
                }else{
                    return "redirect:/notlogin";
                }
            }else{
                Consultant con=consultantService.loginCon(no,password);
                if(con!=null){
                    httpSession.setAttribute("uid",no);
                    return "redirect:/toConsultantPage";
                }else {
                    return "redirect:/notlogin";
                }
            }
        }catch(Exception e){
            return "redirect:/notlogin";
        }
    }

    @GetMapping("/deleteUser")
    public String deleteUser(String s_no){
        stuService.deleteStu(s_no);
        return "redirect:/admin/StuList";
    }
    @GetMapping("findUser")
    public String findUser(String s_no, Model model){
        Student stu=stuService.findStu(s_no);
        model.addAttribute("stu",stu);
        return "admin/editUser";

    }

    @PostMapping("editUser")
    public String editUser(Student student){
        stuService.editStu(student);
        return "redirect:/admin/StuList";
    }


    @GetMapping("doTest")
    public String doTest(Model model,HttpSession httpSession){
        List<Testquestion> questiongs=testqService.randomSelect();
        model.addAttribute("qs",questiongs);
        model.addAttribute("username",httpSession.getAttribute("uid"));
        return "user/doTest";
    }



    @PostMapping("subQ")
    public String subQ(Record records){
        System.out.println(records.toString());
        int score=0;
        switch (records.getAnswer1()){
            case "A": score+=testqService.scoreA(records.getTestno1());break;
            case "B": score+=testqService.scoreB(records.getTestno1());break;
            case "C": score+=testqService.scoreC(records.getTestno1());break;
            case "D": score+=testqService.scoreD(records.getTestno1());break;
            default:break;
        }
        switch (records.getAnswer2()){
            case "A": score+=testqService.scoreA(records.getTestno2());break;
            case "B": score+=testqService.scoreB(records.getTestno2());break;
            case "C": score+=testqService.scoreC(records.getTestno2());break;
            case "D": score+=testqService.scoreD(records.getTestno2());break;
            default:break;
        }
        switch (records.getAnswer3()){
            case "A": score+=testqService.scoreA(records.getTestno3());break;
            case "B": score+=testqService.scoreB(records.getTestno3());break;
            case "C": score+=testqService.scoreC(records.getTestno3());break;
            case "D": score+=testqService.scoreD(records.getTestno3());break;
            default:break;
        }
        switch (records.getAnswer4()){
            case "A": score+=testqService.scoreA(records.getTestno4());break;
            case "B": score+=testqService.scoreB(records.getTestno4());break;
            case "C": score+=testqService.scoreC(records.getTestno4());break;
            case "D": score+=testqService.scoreD(records.getTestno4());break;
            default:break;
        }
        switch (records.getAnswer5()){
            case "A": score+=testqService.scoreA(records.getTestno5());break;
            case "B": score+=testqService.scoreB(records.getTestno5());break;
            case "C": score+=testqService.scoreC(records.getTestno5());break;
            case "D": score+=testqService.scoreD(records.getTestno5());break;
            default:break;
        }
        System.out.println(score);
        records.setScore(score);
        recordService.saveRecord(records);
        return "user/index";

    }

    @GetMapping("/stuactList")
    public String actList(Model model,HttpSession httpSession){
        httpSession.setAttribute("uid","123");
        String id=httpSession.getAttribute("uid").toString();
        List<AttenActivity> attens= attActService.FindAttBysno(id);
        if(attens.size()==0){
            model.addAttribute("hasAct","no");
        }else{
            List<String> atts=new ArrayList<>();
            for(int i=0;i<attens.size();i++){
                int a=attens.get(i).getActNo();
                String b=a+"";
                atts.add(b);
            }
            model.addAttribute("hasAct",atts);
        }
        model.addAttribute("actList",actService.allAct());
        return "user/stuactList";
    }

    @GetMapping("/addAtt")
    public String addAtt(int ActNo,HttpSession httpSession){

        String s_no=httpSession.getAttribute("uid").toString();
        AttenActivity attenActivity=new AttenActivity();
        attenActivity.setActNo(ActNo);
        attenActivity.setS_no(s_no);
        System.out.println("123");
        System.out.println(attenActivity.toString());
        attActService.AddAttAct(attenActivity);
        return "redirect:/user/stuactList";
    }

}
