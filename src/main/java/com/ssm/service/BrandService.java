package com.ssm.service;



import com.ssm.pojo.Brand;
import com.ssm.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> queryBrand(String brandName);

    boolean addBrand(Brand brand);

    boolean brandDelete(long brandId);

    boolean brandDeleteBatch(String ids);

    Brand queryBrandId(long brangId);

    boolean updateBrand(Brand brand);

    PageBean<Brand> brandPage(String brandName, int currentPage, int pageSize);
}
