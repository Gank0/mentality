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
import java.util.*;

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
    @Autowired
    private EventService eventService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AttActService attActService;

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
    public String deTest(int R_no,Model model){
        List<Testquestion> testquestions = new LinkedList<>();
        Record record=recordService.findRecord(R_no);
        testquestions.add(testqService.findQByNo(record.getTestno1()));
        testquestions.add(testqService.findQByNo(record.getTestno2()));
        testquestions.add(testqService.findQByNo(record.getTestno3()));
        testquestions.add(testqService.findQByNo(record.getTestno4()));
        testquestions.add(testqService.findQByNo(record.getTestno5()));
        testquestions.add(testqService.findQByNo(record.getTestno6()));
        testquestions.add(testqService.findQByNo(record.getTestno7()));
        testquestions.add(testqService.findQByNo(record.getTestno8()));
        testquestions.add(testqService.findQByNo(record.getTestno9()));
        testquestions.add(testqService.findQByNo(record.getTestno10()));
        testquestions.add(testqService.findQByNo(record.getTestno11()));
        testquestions.add(testqService.findQByNo(record.getTestno12()));
        testquestions.add(testqService.findQByNo(record.getTestno13()));
        testquestions.add(testqService.findQByNo(record.getTestno14()));
        testquestions.add(testqService.findQByNo(record.getTestno15()));
        testquestions.add(testqService.findQByNo(record.getTestno16()));
        testquestions.add(testqService.findQByNo(record.getTestno17()));
        testquestions.add(testqService.findQByNo(record.getTestno18()));
        testquestions.add(testqService.findQByNo(record.getTestno19()));
        testquestions.add(testqService.findQByNo(record.getTestno20()));
        model.addAttribute("questions",testquestions);
        List<String> ans=new LinkedList<>();
        ans.add(record.getAnswer1());
        ans.add(record.getAnswer2());
        ans.add(record.getAnswer3());
        ans.add(record.getAnswer4());
        ans.add(record.getAnswer5());
        ans.add(record.getAnswer6());
        ans.add(record.getAnswer7());
        ans.add(record.getAnswer8());
        ans.add(record.getAnswer9());
        ans.add(record.getAnswer10());
        ans.add(record.getAnswer11());
        ans.add(record.getAnswer12());
        ans.add(record.getAnswer13());
        ans.add(record.getAnswer14());
        ans.add(record.getAnswer15());
        ans.add(record.getAnswer16());
        ans.add(record.getAnswer17());
        ans.add(record.getAnswer18());
        ans.add(record.getAnswer19());
        ans.add(record.getAnswer20());
        model.addAttribute("ans",ans);
        model.addAttribute("score",record.getScore());
        model.addAttribute("type0",record.getType0());
        model.addAttribute("type1",record.getType1());
        model.addAttribute("type2",record.getType2());
        model.addAttribute("type3",record.getType3());

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
    @GetMapping("/actDeatail")
    public String actDeatail(int ActNo,Model model){
        List<AttenActivity> attenActivities=attActService.FindAttByAno(ActNo);
        List<Student> students=new LinkedList<>();
        for(int i=0;i<attenActivities.size();i++){
            students.add(stuService.findStu(attenActivities.get(i).getS_no()));
        }
        model.addAttribute("stus",students);
        return "admin/actStuList";
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



    @GetMapping("/score")
    public String giveScore(int E_no,Model model){
        Event events=eventService.FindEventByEno(E_no);
        model.addAttribute("events",events);
        return "admin/editEventScore";
    }
    @PostMapping("saveEventScore")
    public String saveEventScore(int E_no,int e_score){
        eventService.updateScore(E_no,e_score);
        return "redirect:/admin/findAllEvent";
    }
    //显示所有保健员活动
    @GetMapping("/findAllEvent")
    public String findAllEvent(Model model){
        List<Event> events=eventService.FindAllEvent();
        Map<Event,Student> map=new HashMap<>();

        for(int i = 0 ; i < events.size() ; i++) {
            if(stuService.findStu(events.get(i).getS_no())!=null){
                map.put(events.get(i),stuService.findStu(events.get(i).getS_no()));
            }else{
                Student stu=new Student();
                map.put(events.get(i),stu);
            }
        }
        model.addAttribute("map",map);
        return "admin/eventList";
    }
    //保健员活动排名
    @GetMapping("getScoreRank")
    public String getScoreRank(Model model){
        List<ScoreAndStu> map=eventService.RankScore();
        model.addAttribute("map",map);
        return "admin/rank";
    }
    //学院平均分
    @GetMapping("collegeRank")
    public String collegeRank(Model model){
        List<collegeAvg> avgs=eventService.avgsEventCollege();
        model.addAttribute("avgs",avgs);
        List<Double> avg=new LinkedList<>();
        List<String> collegeSet=new LinkedList<>();
        for(int i=0;i<avgs.size();i++){
            avg.add(avgs.get(i).getAvgs());
            collegeSet.add(avgs.get(i).getS_college());
        }
        model.addAttribute("avg",avg);
        model.addAttribute("collegeSet",collegeSet);
        return "admin/rankCollege";
    }
    @GetMapping("collegeRankCopy")
    public String collegeRankCopy(Model model){
        List<collegeSum> sums=eventService.countEventCollege();
        model.addAttribute("sums",sums);
        List<Integer> sum=new LinkedList<>();
        List<String> collegeSet=new LinkedList<>();
        for(int i=0;i<sums.size();i++){
            sum.add(sums.get(i).getNums());
            collegeSet.add(sums.get(i).getS_college());
        }
        model.addAttribute("sum",sum);
        model.addAttribute("collegeSet",collegeSet);
        return "admin/rankCollegeCopy";
    }

    @GetMapping("searchRoom")
    public String searchRoom(Model model){
        List<Conroom> conrooms=roomService.findAllRoom();
        List<String> rooms=new LinkedList<>();
        for(int i=0;i<conrooms.size();i++){
            rooms.add(conrooms.get(i).getRoomName());
        }
        model.addAttribute("rooms",rooms);
        return "admin/searchRoom";
    }

    @PostMapping("roomSearch")
    public String roomSearch(String room, Model model){
        List<Appointment> apps=appoService.findAppByRoom(room);
        model.addAttribute("appos",apps);
        List<Conroom> conrooms=roomService.findAllRoom();
        List<String> rooms=new LinkedList<>();
        for(int i=0;i<conrooms.size();i++){
            rooms.add(conrooms.get(i).getRoomName());
        }
        model.addAttribute("rooms",rooms);
        return "admin/searchRoom";

    }

    @GetMapping("articleList")
    public String articleList(Model model){
        List<Article> articles=articleService.FindAllArticle();
        model.addAttribute("articles",articles);
        return "admin/articleList";
    }
    @GetMapping("toArticleAdd")
    public String toArticleAdd(){
        return "admin/addArticle";
    }
    @PostMapping("addArticle")
    public String addArticle(Article article){
        Date date=new Date();
        article.setArticle_Time(date);
        articleService.AddArticle(article);
        return "redirect:/admin/articleList";
    }
    @GetMapping("toEditArticle")
    public String toEditArticle(Integer id,Model model){
        Article article= articleService.FindArticleById(id);
        model.addAttribute("article",article);
        return "admin/editArticle";
    }
    @PostMapping("editArticle")
    public String editArticle(Article article){
        article.setArticle_Time(new Date());
        articleService.updateArticleById(article);
        return "redirect:/admin/articleList";
    }



}
