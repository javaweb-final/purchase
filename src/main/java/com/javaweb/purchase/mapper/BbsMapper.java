package com.javaweb.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.purchase.entity.Bbs;
import com.javaweb.purchase.entity.BbsUserVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsMapper extends BaseMapper<Bbs> {

    @Select("SELECT username,title,info,time,bbs.id FROM bbs ,user where bbs.user_id=user.id")
    List<BbsUserVo> findAllBbs();

    @Select("SELECT username,title,info,time,bbs.id FROM bbs ,user where bbs.user_id=`user`.id AND bbs.id=#{id}")
    List<BbsUserVo> findDetailInfoById(Integer id);
}
