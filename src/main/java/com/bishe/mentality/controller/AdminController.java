package com.bishe.mentality.controller;

import com.bishe.mentality.dao.StuDAO;
import com.bishe.mentality.entity.*;
import com.bishe.mentality.service.*;

import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @Autowired
    private ActService actService;
    @Autowired
    private AppoService appoService;
    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private RoomService roomService;

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
    @GetMapping("/ConList")
    public String findAllCon(Model model){
        List<Consultant> consultants=consultantService.findAllCon();
        model.addAttribute("cons",consultants);
        return "admin/conManager";
    }
    @GetMapping("/deleteCon")
    public String deleteCon(String id){
        consultantService.deleteCon(id);
        return "redirect:admin/ConList";
    }
    @GetMapping("/editCon")
    public String editInfo(String id, Model model) {
        Consultant con = consultantService.findCon(id);
        model.addAttribute("con", con);
        return "admin/editConInfo";
    }

    @GetMapping("/leaveManage")
    public String leaveMange(Model model){
        System.out.println();
        List<Leave> leaves= leaveService.findAllLeave();
        model.addAttribute("leaves",leaves);
        System.out.println(leaves);
        return "admin/leaveManage";
    }
    @GetMapping("editLeave")
    public String editLeave(int No,Model model){
        Leave leave=leaveService.findLeaveByNo(No);
        model.addAttribute(leave);
        return "admin/editCon";
    }
    @PostMapping("checkLeave")
    public String checkLeave(Leave leave){
        leaveService.editLeave(leave);
        return "redirect:/admin/leaveManage";
    }

    @PostMapping("/saveConInfo")
    public String saveInfo(Consultant consultant) {
        consultantService.editCon(consultant);
        return "redirect:/admin/ConList";
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
    @PostMapping("/actOut")
    public String actOut(Activity activity){
        actService.addAct(activity);
        return "redirect:/admin/actList";
    }
    @GetMapping("/actList")
    public String actList(Model model){
        model.addAttribute("actList",actService.allAct());
        return "admin/actList";
    }
    @GetMapping("/editActState")
    public String editActState(String ActNo){

        actService.editStateByNo(ActNo);
        return "redirect:/admin/actList";
    }
    @GetMapping("/tolowscore")
    public String tolowsc(Model model){
        model.addAttribute("lows","null");
        return "admin/lowStu";
    }
    @PostMapping("/lowscore")
    public String lowscore(int score,Model model){
        System.out.println(score);
        List<Record> lows=recordService.lowRecord(score);
        model.addAttribute("lows",lows);
        return "admin/lowStu";
    }
    @GetMapping("/lowscoreDetail")
    public String lowscorede(String id,Model model){
        Student student=stuService.findStu(id);
        List<Appointment> apps=appoService.findAppoBysno(id);
        model.addAttribute("stu",student);
        if(apps.size()>0){
            model.addAttribute("apps",apps);
        }else{
            model.addAttribute("apps","null");
        }

        return "admin/lowStuDetail";
    }

    //咨询室
    @GetMapping("/findAllRoom")
    public String findAllRoom(Model model){
       List<Conroom> rooms= roomService.findAllRoom();
       model.addAttribute("rooms",rooms);
       return "admin/roomList";
    }

    @GetMapping("/findRoomByName")
    public String findRoomByName(String roomName,Model model){
        Conroom roominfo=roomService.findRoomByName(roomName);
        model.addAttribute("roomInfo",roominfo);
        return "admin/editRoom";
    }

    @PostMapping("/saveEditRoom")
    public String saveeditRoom(Conroom room){
        roomService.updateRoom(room);
        return "redirect:/admin/findAllRoom";
    }
    @GetMapping("/deleteRoom")
    public String deleteRoom(String roomName,Model model){
        roomService.deleteRoom(roomName);
        return "redirect:/admin/findAllRoom";
    }
    @PostMapping("/addRoom")
    public String addRoom(Conroom conroom){
        roomService.addRoom(conroom);
        return "redirect:/admin/findAllRoom";
    }

}
