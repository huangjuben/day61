package com.ssm.controller;

import com.ssm.pojo.PageBean;
import com.ssm.pojo.ResultVo;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String username,String password){
        //调用service层
       User user= userService.login(username,password);
        //返回
        if(user!=null){//登陆成功
                user.setPassword("");
            return ResultVo.success(user);
        }else{//登录失败
            return ResultVo.error();
        }
    }

    //查询用户
    @RequestMapping(value = "/queryUser",method = RequestMethod.GET)
    public Object queryUser(String userAccount){
        List<User> list = userService.queryUser(userAccount);
        return list;
    }

    //添加用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Object addUser(User user){
        System.out.println(user);
        boolean b = userService.addUser(user);
        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("添加失败");
        }

    }

    //删除用户

    @RequestMapping(value = "/deleteUser/{userId}",method = RequestMethod.GET)
    public Object deleteUser(@PathVariable(value = "userId")Integer userId){
        boolean b = userService.deleteUser(userId);
        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("删除失败");
        }
    }

    //批量删除用户

    @RequestMapping( "/batchDeleteUser")
    public Object batchDeleteUser(String ids ){
        System.out.println(ids);
       boolean b = userService.batchDeleteUser(ids);

        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("删除失败");
        }
    }



    //重置密码
    @RequestMapping(value = "/resetPassword/{userId}")
    public Object resetPassword(@PathVariable(value = "userId")Integer userId){
        boolean b = userService.resetPassword(userId);
        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("删除失败");
        }

    }


    //根据用户名模糊查询条数
    @RequestMapping(value = "/queryPage",method = RequestMethod.GET)
    public Object queryPage(String userAccount, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize){
        PageBean<User> pb = userService.queryPage(userAccount,currentPage,pageSize );
        return pb;
    }


    //根据ID查询所有信息
    @RequestMapping(value = "/queryId/{userId}")
    public Object queryId(@PathVariable("userId") int userId){
        User user = userService.queryId(userId);
        return ResultVo.success(user);

    }

    //修改用户
    @RequestMapping(value = "/updateUser")
    public Object updateUser(User user){
        System.out.println(user);
        boolean b =userService.updateUser(user);

        if (b){
            return ResultVo.success();
        }else {
            return ResultVo.error("修改失败");
        }
    }

    //上传头像
    @RequestMapping( value = "/headimage ",produces = "application/json;charset=utf-8")
    public Object upload (@RequestParam MultipartFile file, long userId, HttpServletRequest request) throws IOException {
        System.out.println(file.getOriginalFilename()+userId);
        //获取服务器下的路径：/static/headimgs
        String realPath = request.getServletContext().getRealPath("/static/headimgs");
        File file1 = new File(realPath);
        //判断是否是文件夹，不是则删除后创建
        if (!file1.isDirectory()){
            file1.delete();
            file1.mkdirs();
        }
        //非空则上传
        if (file.isEmpty()){
            return "上传失败";
        }
        //确定上传的名字
        String fileName = UUID.randomUUID().toString().replace("-", "")+".png";
        //上传
        file.transferTo(new File(file1+"/"+fileName));
        //修改头像
        //String urlimg = "http://ip:port/static/headimgs/名字"; ===ip地址:端口号/路径名/名字
        boolean b = userService.upload(userId,"http://localhost:8090/static/headimgs/"+fileName);
        return b?("头像上传成功"):("头像上传失败");

    }

    @RequestMapping("/queryHead/{userId}")
    public Object queryHead(@PathVariable("userId") long userId){
        String url = userService.queryHead(userId);
        return ResultVo.success(url);

    }




}

