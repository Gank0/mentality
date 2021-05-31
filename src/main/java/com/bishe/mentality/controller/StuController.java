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
import java.util.Collections;
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
    @Autowired
    private AppoService appoService;
    @Autowired
    private EventService eventService;
    @Autowired
    private ArticleService articleService;

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
                    httpSession.setAttribute("student", stu);
                    System.out.println("stu = " + stu.getS_name());
                    return "user/index";
                }
                else{
                    httpSession.setAttribute("msg", 0);
                    return "redirect:/notlogin";
                }
            }
            else if(role.equals("admin")){
                Admin adm=adminService.loginAdmin(no,password);
                if(adm!=null){
                    httpSession.setAttribute("uid",no);
                    httpSession.setAttribute("adm", adm);
                    return "redirect:/toAdminPage";
                }else{
                    httpSession.setAttribute("msg", 0);
                    return "index";
                }
            }else{
                Consultant con=consultantService.loginCon(no,password);
                if(con!=null){
                    httpSession.setAttribute("uid",no);
                    httpSession.setAttribute("con",con);
                    return "redirect:/toConsultantPage";
                }else {
                    httpSession.setAttribute("msg", 0);
                    return "index";
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
        List<Testquestion> questions=testqService.randomSelect0();
        questions.addAll(testqService.randomSelect1());
        questions.addAll(testqService.randomSelect2());
        questions.addAll(testqService.randomSelect3());
        Collections.shuffle(questions);//打乱题目
        model.addAttribute("qs",questions);
        model.addAttribute("username",httpSession.getAttribute("uid"));
        return "user/doTest";
    }


    private int getTestno(int Testno,Record record){
        switch (Testno){
            case 1:return record.getTestno1();
            case 2:return record.getTestno2();
            case 3:return record.getTestno3();
            case 4:return record.getTestno4();
            case 5:return record.getTestno5();
            case 6:return record.getTestno6();
            case 7:return record.getTestno7();
            case 8:return record.getTestno8();
            case 9:return record.getTestno9();
            case 10:return record.getTestno10();
            case 11:return record.getTestno11();
            case 12:return record.getTestno12();
            case 13:return record.getTestno13();
            case 14:return record.getTestno14();
            case 15:return record.getTestno15();
            case 16:return record.getTestno16();
            case 17:return record.getTestno17();
            case 18:return record.getTestno18();
            case 19:return record.getTestno19();
            case 20:return record.getTestno20();
            default:return 0;
        }
    }
    private String getAnswer(int Testno,Record record){
        switch (Testno){
            case 1:return record.getAnswer1();
            case 2:return record.getAnswer2();
            case 3:return record.getAnswer3();
            case 4:return record.getAnswer4();
            case 5:return record.getAnswer5();
            case 6:return record.getAnswer6();
            case 7:return record.getAnswer7();
            case 8:return record.getAnswer8();
            case 9:return record.getAnswer9();
            case 10:return record.getAnswer10();
            case 11:return record.getAnswer11();
            case 12:return record.getAnswer12();
            case 13:return record.getAnswer13();
            case 14:return record.getAnswer14();
            case 15:return record.getAnswer15();
            case 16:return record.getAnswer16();
            case 17:return record.getAnswer17();
            case 18:return record.getAnswer18();
            case 19:return record.getAnswer19();
            case 20:return record.getAnswer20();
            default:return "null";
        }
    }

    @PostMapping("subQ")
    public String subQ(Record records){
        System.out.println(records.toString());
        int score=0;
        int type0=0;
        int type1=0;
        int type2=0;
        int type3=0;
        /*同上*/
        for(int i=1;i<21;i++) {
            switch (getAnswer(i, records)) {
                case "A": {
                    score += testqService.scoreA(getTestno(i, records));
                    switch (testqService.typeQ(getTestno(i, records))) {
                        case 0:
                            type0+= testqService.scoreA(getTestno(i, records)) * 4;
                            break;
                        case 1:
                            type1+= testqService.scoreA(getTestno(i, records)) * 4;
                            break;
                        case 2:
                            type2+= testqService.scoreA(getTestno(i, records)) * 4;
                            break;
                        case 3:
                            type3+= testqService.scoreA(getTestno(i, records)) * 4;
                            break;
                        default:
                            break;
                    }
                    break;
                }
                case "B": {
                    score += testqService.scoreB(getTestno(i, records));
                    switch (testqService.typeQ(getTestno(i, records))) {
                        case 0:
                            type0+= testqService.scoreB(getTestno(i, records)) * 4;
                            break;
                        case 1:
                            type1+= testqService.scoreB(getTestno(i, records)) * 4;
                            break;
                        case 2:
                            type2+= testqService.scoreB(getTestno(i, records)) * 4;
                            break;
                        case 3:
                            type3+= testqService.scoreB(getTestno(i, records)) * 4;
                            break;
                        default:
                            break;
                    }
                    break;
                }
                case "C": {
                    score += testqService.scoreC(getTestno(i, records));
                    switch (testqService.typeQ(getTestno(i, records))) {
                        case 0:
                            type0 += testqService.scoreC(getTestno(i, records)) * 4;
                            break;
                        case 1:
                            type1 += testqService.scoreC(getTestno(i, records)) * 4;
                            break;
                        case 2:
                            type2 += testqService.scoreC(getTestno(i, records)) * 4;
                            break;
                        case 3:
                            type3 += testqService.scoreC(getTestno(i, records)) * 4;
                            break;
                        default:
                            break;
                    }
                    break;
                }
                case "D": {
                    score += testqService.scoreD(getTestno(i, records));
                    switch (testqService.typeQ(getTestno(i, records))) {
                        case 0:
                            type0 += testqService.scoreD(getTestno(i, records)) * 4;
                            break;
                        case 1:
                            type1 += testqService.scoreD(getTestno(i, records)) * 4;
                            break;
                        case 2:
                            type2 += testqService.scoreD(getTestno(i, records)) * 4;
                            break;
                        case 3:
                            type3 += testqService.scoreD(getTestno(i, records)) * 4;
                            break;
                        default:
                            break;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        records.setScore(score);
        records.setType0(type0);
        records.setType1(type1);
        records.setType2(type2);
        records.setType3(type3);
        records.setR_no(0);
        recordService.saveRecord(records);
        return "user/index";

    }

    @GetMapping("/stuactList")
    public String actList(Model model,HttpSession httpSession){
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

    @GetMapping("/findAppoByno")
    public String findAppoByno(Model model,HttpSession httpSession){
        String id=httpSession.getAttribute("uid").toString();

        List<Appointment> appos=appoService.findAppoBysno(id);
        model.addAttribute("appos",appos);
        System.out.println(appos);
        return "user/myAppoList";
    }
    @GetMapping("/toAddEvent")
    public String toAddEvent(HttpSession httpSession,Model model){
        String id=httpSession.getAttribute("uid").toString();
        model.addAttribute("uid",id);
        return "user/addEvent";

    }
    @GetMapping("/stuEventList")
    public String stuEventList(HttpSession httpSession,Model model){
        String id=httpSession.getAttribute("uid").toString();
        List<Event> es=eventService.FindEventById(id);
        if(es==null){
            return "user/eventList";
        }
        model.addAttribute("events",es);
        return "user/eventList";
    }

    @PostMapping("/addEvent")
    public String addEvent(Event event){
        System.out.println(event.toString());
        eventService.AddEvent(event);
        return "redirect:/user/stuEventList";
    }

    @GetMapping("articleList")
    public String articleList(Model model){
        List<Article> articles=articleService.FindAllArticle();
        model.addAttribute("articles",articles);
        return "user/articleList";
    }
    @GetMapping("seeArticle")
    public String seeArticle(Integer Id,Model model){
        Article article=articleService.FindArticleById(Id);
        model.addAttribute("article",article);
        return "user/seeArticle";
    }


}
