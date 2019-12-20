package com.javaweb.purchase.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaweb.purchase.entity.Bbs;
import com.javaweb.purchase.entity.BbsUserVo;
import com.javaweb.purchase.entity.User;
import com.javaweb.purchase.mapper.BbsMapper;
import com.javaweb.purchase.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bbs")
public class BbsController {
    @Autowired
    private BbsService bbsService;

    @RequestMapping("/all")
    public String all(Model model){
        List<BbsUserVo> l=bbsService.findAllBbs();

        model.addAttribute("bbsdata",l);
        return "bbs_easy";


    }
    @RequestMapping("/info")
    public String info(Model model, HttpServletRequest request){
        int id=Integer.valueOf(request.getParameter("id"));
        List<BbsUserVo> l=bbsService.findInfo(id);
        model.addAttribute("bbs",l);
        return "bbs_deatil";
    }
    @RequestMapping("edit")
    public String edit(){
        return "bbs_add";
    }
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(HttpSession session, HttpServletRequest request){
        User user=(User) session.getAttribute("user");
        int userid=user.getId();
        String bbsinfo=request.getParameter("bbsinfo");
        String bbstitle =request.getParameter("bbstitle");
        Date time=new Date();
        Bbs bbs=new Bbs();
        bbs.setInfo(bbsinfo);
        bbs.setTitle(bbstitle);
        bbs.setUser_id(userid);
        bbs.setTime(time);
        bbsService.save(bbs);
        return "success";
    }
}
