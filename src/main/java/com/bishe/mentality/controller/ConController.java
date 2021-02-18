package com.bishe.mentality.controller;

import com.bishe.mentality.entity.Appointment;
import com.bishe.mentality.entity.Conroom;
import com.bishe.mentality.entity.Consultant;
import com.bishe.mentality.entity.Student;
import com.bishe.mentality.service.AppoService;
import com.bishe.mentality.service.ConsultantService;
import com.bishe.mentality.service.RoomService;
import com.bishe.mentality.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/findAllCon")
    public String findAllCon(Model model){
        List<Consultant> Cons=consultantService.findAllCon();
        model.addAttribute("Cons",Cons);
        return "user/consList";
    }
    @GetMapping("/findConById")
    public String findConByid(String id, Model model, HttpSession httpSession){
        Consultant con=consultantService.findCon(id);
        List<Date> busyDay=consultantService.busyDay(id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //获取今天的日期
        String startday=sdf.format(new Date());
        //获取30天后的日期
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,30);
        String endday=sdf.format(calendar.getTime());
        model.addAttribute("con",con);
        model.addAttribute("busyDay",busyDay);
        model.addAttribute("startday",startday);
        model.addAttribute("endday",endday);
        model.addAttribute("uid",httpSession.getAttribute("uid"));
        return "user/consultant";
    }
    @PostMapping("/creatApp")
    public String creatApp(Appointment appointment){
        System.out.println(appointment);
        appoService.creatAppo(appointment);
        return "redirect:/consulant/findAllCon";
    }

    @GetMapping("/findAppoBycid")
    public String findappcid(Model model,HttpSession httpSession){
        String c_id=httpSession.getAttribute("uid").toString();
        List<Appointment> appo=appoService.findAppoBycid(c_id);
        model.addAttribute("appos",appo);
        return "consultant/appList";
    }

    @GetMapping("/editAppo")
    public String editAppo(String appointNo,String s_no,Model model){
        Appointment appointment=appoService.findAppoByno(appointNo);
        Student student=stuService.findStu(s_no);
        List<Conroom> rooms=roomService.findAllRoom();
        model.addAttribute("stu",student);
        model.addAttribute("appoint",appointment);
        model.addAttribute("rooms",rooms);
        return "consultant/editAppo";
    }

    @PostMapping("/updateAppo")
    public String updateAppo(Appointment appointment,HttpSession httpSession){
        appoService.updateAppo(appointment);
        String c_id=httpSession.getAttribute("uid").toString();
        return "redirect:/consulant/findAppoBycid?c_id="+c_id;
    }

}
