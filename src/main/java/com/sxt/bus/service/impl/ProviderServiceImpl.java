package com.sxt.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.mapper.ProviderMapper;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.utils.DataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:14
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;
    /**
     * 模糊加分页
     *
     * @param providerVo
     * @return
     */
    @Override
    public DataView queryAllProvider(ProviderVo providerVo) {
        Page<Object> page = PageHelper.startPage(providerVo.getPage(),providerVo.getLimit());
        List<Provider> providers = this.providerMapper.queryAllProvider(providerVo);

        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            providerVo.setPage(providerVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(providerVo.getPage(),providerVo.getLimit());
            List<Provider> providers2 = this.providerMapper.queryAllProvider(providerVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),providers2);
        }

        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),providers);
    }

    /**
     * 添加
     *
     * @param providerVo
     */
    @Override
    public void addProvider(ProviderVo providerVo) {
        this.providerMapper.insertSelective(providerVo);
    }

    /**
     * 修改
     *
     * @param providerVo
     */
    @Override
    public void updateProvider(ProviderVo providerVo) {
        this.providerMapper.updateByPrimaryKeySelective(providerVo);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteProvider(Integer id) {
        this.providerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所有的商家集合
     *
     * @param provider
     * @return
     */
    @Override
    public List<Provider> queryAllProvider(Provider provider) {

        return this.providerMapper.queryAllProvider(provider);
    }
}
