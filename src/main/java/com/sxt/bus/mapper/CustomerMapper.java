package com.sxt.bus.mapper;

import com.sxt.bus.domain.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    //查询
    List<Customer> queryAllCustomer(Customer customer);
}