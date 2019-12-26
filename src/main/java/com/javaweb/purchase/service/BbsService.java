package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.Bbs;
import com.javaweb.purchase.entity.BbsUserVo;
import com.javaweb.purchase.mapper.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BbsService extends ServiceImpl<BbsMapper, Bbs> {
    @Autowired
    private BbsMapper bbsMapper;
    public List<BbsUserVo> findAllBbs(){
        return bbsMapper.findAllBbs();
    }
    public List<BbsUserVo> findInfo(Integer id){
        return bbsMapper.findDetailInfoById(id);
    }
}
