package com.ssm.service.impl;

import com.ssm.mapper.BrandMapper;
import com.ssm.pojo.Brand;
import com.ssm.pojo.PageBean;
import com.ssm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BrandImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryBrand(String brandName) {
        return brandMapper.queryBrand(brandName);
    }

    @Override
    @Transactional
    public boolean addBrand(Brand brand) {
        brand.setBrandStatus(1);
        return brandMapper.addBrand(brand) > 0;
    }

    @Override
    public boolean brandDelete(long brandId) {
        return brandMapper.brandDelete(brandId) > 0;
    }

    @Override
    public boolean brandDeleteBatch(String brandDel) {
        String[] arr = brandDel.split(",");
        return brandMapper.brandDeleteBatch(arr) > 0;
    }

    @Override
    public Brand queryBrandId(long brandId) {
        return brandMapper.queryBrandId(brandId);
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand) > 0;
    }

    @Override
    public PageBean<Brand> brandPage(String brandName, int currentPage, int pageSize) {
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);

        int total= brandMapper.brandPageCount(brandName);
        pageBean.setTotal(total);
        List list =brandMapper.brandPage(brandName, (currentPage-1)*pageSize, pageSize);
        pageBean.setData(list);
        return pageBean;
    }
}
