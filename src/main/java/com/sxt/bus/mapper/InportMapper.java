package com.sxt.bus.mapper;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.vo.InportVo;

import java.util.List;

public interface InportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inport record);

    int insertSelective(Inport record);

    Inport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inport record);

    int updateByPrimaryKey(Inport record);

    //查询
    List<InportVo> queryAllInport(InportVo inportVo);
}