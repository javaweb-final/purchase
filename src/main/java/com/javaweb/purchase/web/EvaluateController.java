package com.javaweb.purchase.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaweb.purchase.entity.*;
import com.javaweb.purchase.mapper.EvaluateMapper;
import com.javaweb.purchase.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/eval")
@ResponseBody
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;
    /**
     * 获取评价信息
     */
    @RequestMapping("/getEvaluateData")
    public String getEvaluateData(Model model){
        QueryWrapper<Evaluate> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("thing_id",2);
        IPage<Evaluate> iPage=evaluateService.page(new Page<>(1,4),queryWrapper);
        model.addAttribute("evaluateList",iPage.getRecords());
        return "evaluateData";
    }
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        int id=user.getId();
        int productId=Integer.valueOf(request.getParameter("productId"));
        String evaluateinfo=request.getParameter("evaluateinfo");
        //判断是否已经在购物车存在该记录
        List<UserOrderVo> l=evaluateService.findUserOrder(id,productId);

        if(l.size() == 0){
            return "100";
        } else {
            Evaluate evaluate=new Evaluate();
            evaluate.setDetail(evaluateinfo);
            evaluate.setThingId(productId);
            evaluate.setUserId(id);
            evaluateService.save(evaluate);
            return "101";
        }

    }

//    public String getEvaluateData(Model model,Integer id){
//        id=2;
//        QueryWrapper<Evaluate> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("thing_id",id);
//        List<Evaluate> evaluateList=evaluateService.list(queryWrapper);
//
//        model.addAttribute("evaluateList",evaluateList);
//        return "evaluateData";
//    }
}
