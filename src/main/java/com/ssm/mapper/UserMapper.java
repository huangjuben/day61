package com.ssm.mapper;

import com.ssm.pojo.PageBean;
import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserMapper {

    //查询用户名和密码
    User queryNameAndPwd(@Param("username") String username, @Param("password") String password);

    //查询所有
    List<User> queryUser(@Param("uname") String username);

    //添加数据
    int addUser(User user);

    //删除数据
    int deleteId(Integer userId);

    //批量删除用户
    int batchDeleteId(@Param("ids") String[] split);

    //重置密码
    boolean resetPassword(@Param("userId") Integer userId, @Param("password") String password);

    //分页查询
    int queryPageCount(@Param("name") String account);
    List<User> queryPage(@Param("name") String account, @Param("begin") int currentPage, @Param("limit") int pageSize);

    //根据ID查询
    User queryId(@Param("userId") int userId);

    //修改用户信息
    int updateUser(User user);


    int upload(@Param("userId") long userId,@Param("url") String url);

    String queryHead(@Param("userId") long userId);
}
