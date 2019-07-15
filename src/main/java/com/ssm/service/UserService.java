package com.ssm.service;

import com.ssm.pojo.PageBean;
import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //登录
    User login(String username, String password);

    //查询所有
    List<User> queryUser(String username);

    //添加用户
    boolean addUser(User user);

    //删除用户
    boolean deleteUser(Integer userId);
    //批量删除用户
    boolean batchDeleteUser(String ids);
    //重置密码
    boolean resetPassword(Integer userId);
    //分页查询
    PageBean<User> queryPage(String userAccount, int currentPage, int pageSize);
    //根据ID查询用户
    User queryId(@Param("userId") int userId);
    //修改用户
    boolean updateUser(User user);


    boolean upload(long userId, String url);

    String queryHead(long userId);
}
