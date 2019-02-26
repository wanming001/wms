package com.sxt.bus.mapper;

import com.sxt.bus.domain.Provider;

import java.util.List;

public interface ProviderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);

    //查询
    List<Provider> queryAllProvider(Provider provider);
}