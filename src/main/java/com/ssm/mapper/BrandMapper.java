package com.ssm.mapper;

import com.ssm.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> queryBrand(@Param("brandName") String brandName);

    int addBrand(Brand brand);

    int brandDelete(@Param("brandId") long brandId);

    int brandDeleteBatch(@Param("brandDel") String[] arr);

    Brand queryBrandId(@Param("brandId") long brandId);

    int updateBrand(Brand brand);

    int brandPageCount(@Param("brandName") String brandName);
    List brandPage(@Param("brandName") String brandName, @Param("begin") int currentPage, @Param("limit") int pageSize);
}
