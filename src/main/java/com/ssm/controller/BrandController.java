package com.ssm.controller;


import com.ssm.pojo.Brand;
import com.ssm.pojo.PageBean;
import com.ssm.pojo.ResultVo;
import com.ssm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/queryBrand")
    public Object queryBrand(String brandName){
       List<Brand> list = brandService.queryBrand(brandName);

        return list;
    }


    @RequestMapping("/addBrand")
    public Object addBrand(Brand brand){
       boolean b = brandService.addBrand(brand);

       if (b){
           return ResultVo.success();
       }else {
           return ResultVo.error("添加失败");
       }
    }

    @RequestMapping("/brandDelete/{brandId}")
    public Object brandDelete(@PathVariable("brandId") long brandId){
        boolean b = brandService.brandDelete(brandId);
        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("删除失败");
        }
    }

    @RequestMapping("/brandDeleteBatch")
    public Object brandDelete(String brandDel){
          boolean b =brandService.brandDeleteBatch(brandDel);
        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("删除失败");
        }
    }

    @RequestMapping("/queryBrandId/{brandId}")
    public Object queryBrandId(@PathVariable("brandId")long brangId){
      Brand brand = brandService.queryBrandId(brangId);

      return ResultVo.success(brand);

    }

    @RequestMapping("/updateBrand")
    public Object updateBrand(Brand brand){
        boolean b = brandService.updateBrand(brand);
        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("删除失败");
        }
    }

    @RequestMapping("/brandPage")
    public Object brandPage(String brandName, int currentPage,int pageSize){
       PageBean<Brand> pageBean =brandService.brandPage(brandName,currentPage,pageSize);
        return pageBean;

    }









}
