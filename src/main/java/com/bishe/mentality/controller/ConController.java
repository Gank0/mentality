package com.bishe.mentality.controller;

import com.bishe.mentality.entity.*;
import com.bishe.mentality.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/consulant")
public class ConController {
    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private AppoService appoService;

    @Autowired
    private StuService stuService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/findAllCon")
    public String findAllCon(Model model) {
        List<Consultant> Cons = consultantService.findAllCon();
        model.addAttribute("Cons", Cons);
        return "user/consList";
    }

    @GetMapping("/findConById")
    public String findConByid(String id, Model model, HttpSession httpSession) {
        Consultant con = consultantService.findCon(id);
        List<Date> busyDay = consultantService.busyDay(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取今天的日期
        String startday = sdf.format(new Date());
        //获取30天后的日期
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, 30);
        String endday = sdf.format(calendar.getTime());
        model.addAttribute("con", con);
        model.addAttribute("busyDay", busyDay);
        model.addAttribute("startday", startday);
        model.addAttribute("endday", endday);
        model.addAttribute("uid", httpSession.getAttribute("uid"));
        return "user/consultant";
    }

    @PostMapping("/creatApp")
    public String creatApp(Appointment appointment) {
        appoService.creatAppo(appointment);
        return "redirect:/consulant/findAllCon";
    }

    @GetMapping("/findAppoBycid")
    public String findappcid(Model model, HttpSession httpSession) {
        String c_id = httpSession.getAttribute("uid").toString();
        List<Appointment> appo = appoService.findAppoBycid(c_id);
        model.addAttribute("appos", appo);
        return "consultant/appList";
    }

    @GetMapping("/editAppo")
    public String editAppo(String appointNo, String s_no, Model model) {
        Appointment appointment = appoService.findAppoByno(appointNo);
        Student student = stuService.findStu(s_no);
        List<Conroom> rooms = roomService.findAllRoom();
        model.addAttribute("stu", student);
        model.addAttribute("appoint", appointment);
        model.addAttribute("rooms", rooms);
        return "consultant/editAppo";
    }

    @PostMapping("/updateAppo")
    public String updateAppo(Appointment appointment, HttpSession httpSession) {
        appoService.updateAppo(appointment);
        String c_id = httpSession.getAttribute("uid").toString();
        return "redirect:/consulant/findAppoBycid?c_id=" + c_id;
    }

    @GetMapping("/editInfo")
    public String editInfo(HttpSession httpSession, Model model) {
        String c_id=httpSession.getAttribute("uid").toString();
        Consultant con = consultantService.findCon(c_id);
        model.addAttribute("con", con);
        return "consultant/editInfo";

    }

    @PostMapping("/saveInfo")
    public String saveInfo(Consultant consultant) {
        consultant.toString();
        consultantService.editCon(consultant);
        return "redirect:/toConsultantPage";
    }

    @GetMapping("/leave")
    public String leave(Model model, HttpSession httpSession, @ModelAttribute("state")String state) {
        String id = httpSession.getAttribute("uid").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取今天的日期
        String startday = sdf.format(new Date());
        //获取30天后的日期
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, 30);
        String endday = sdf.format(calendar.getTime());
        model.addAttribute("startday", startday);
        model.addAttribute("endday", endday);
        try {model.addAttribute("state",state);
            System.out.println("前:"+state);
        }
        catch (Exception e){
            model.addAttribute("state","0");
            System.out.println("后："+state);
        }

        return "consultant/vacate";
    }

    @PostMapping("/checkLeave")
    public String checkLeave(Leave leave, Model model, RedirectAttributes redirectAttributes,HttpSession httpSession) {
       // String cid=httpSession.getAttribute("uid").toString();
        String cid="121";
        //开始时间大于结束时间
        if (leave.getLeaveEndTime().before(leave.getLeaveStartTime())) {
            redirectAttributes.addFlashAttribute("state","1");
            return "redirect:/consulant/leave";
        }
        //在这时间内有预约
        else if(!appoService.findConBetweenDate(leave.getLeaveStartTime(),leave.getLeaveEndTime(),cid).isEmpty()){
            redirectAttributes.addFlashAttribute("state","2");
           return "redirect:/consulant/leave";
        }else{
            leaveService.addLeave(leave);
            return "redirect:/consulant/findLeaveByid";
        }
    }
    @GetMapping("/findLeaveByid")
    public String findLeaveByid(String id,HttpSession httpSession,Model model){
      //  String cid=httpSession.getAttribute("uid").toString();
        String cid="121";
        List<Leave> leaves=leaveService.findLeaveByid(cid);
        model.addAttribute("leaves",leaves);
        return "consultant/leaveList";
    }
}
