package com.sxt.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.bus.domain.Customer;
import com.sxt.bus.mapper.CustomerMapper;
import com.sxt.bus.service.CustomerService;
import com.sxt.sys.utils.DataView;
import com.sxt.bus.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:14
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    /**
     * 模糊加分页
     *
     * @param customerVo
     * @return
     */
    @Override
    public DataView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page = PageHelper.startPage(customerVo.getPage(),customerVo.getLimit());
        List<Customer> customers = this.customerMapper.queryAllCustomer(customerVo);
        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            customerVo.setPage(customerVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(customerVo.getPage(),customerVo.getLimit());
            List<Customer> providers2 = this.customerMapper.queryAllCustomer(customerVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),providers2);
        }
        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),customers);
    }

    /**
     * 添加
     *
     * @param customerVo
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        this.customerMapper.insertSelective(customerVo);
    }

    /**
     * 修改
     *
     * @param customerVo
     */
    @Override
    public void updateCustomer(CustomerVo customerVo) {
        this.customerMapper.updateByPrimaryKeySelective(customerVo);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteCustomer(Integer id) {
        this.customerMapper.deleteByPrimaryKey(id);
    }
}
