package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.PageBean;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        /**
         * 需要对密码加密之后进行查询
         */
        //调用mapper去实现登录
        User user = userMapper.queryNameAndPwd(username, MD5Utils.encrypt(password));
        return user;
    }

    @Override
    public List<User> queryUser(String username) {
        return userMapper.queryUser(username);
    }

    @Override
    public boolean addUser(User user) {

        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setStatus(1);//默认是1 表示激活可用
        //设置用户创建的事件
        user.setCreateTime(new Date());

        return userMapper.addUser(user)>0;
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return userMapper.deleteId(userId) > 0;
    }

    @Override
    @Transactional
    public boolean batchDeleteUser(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return false;
        }
        String[] split = ids.split(",");
        if (split != null && split.length > 0) {
            int row = userMapper.batchDeleteId(split);
            return row > 0;
        }
        return false;
    }

    @Override
    public boolean resetPassword(Integer userId) {
        String password = MD5Utils.encrypt("123456");

        return userMapper.resetPassword(userId, password);
    }


    @Override
    public PageBean<User> queryPage(String userAccount, int currentPage, int pageSize) {
        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        //根据用户名模糊查询总条数
        int total = userMapper.queryPageCount(userAccount);
        pb.setTotal(total);
        //模糊查询分页返回数据
        List list = userMapper.queryPage(userAccount, (currentPage - 1) * pageSize, pageSize);
        pb.setData(list);
        return pb;

    }

    @Override
    public User queryId(int userId) {
        return userMapper.queryId(userId);
    }

    @Override
    public boolean updateUser(User user) {
       /* if (user.getUserId() == null || StringUtils.isEmpty(user.getUserName())) {
            return false;
        }*/
        return userMapper.updateUser(user)>0;
    }


    @Override
    public boolean upload(long userId, String url) {
        return userMapper.upload(userId,url)>0;
    }

    @Override
    public String queryHead(long userId) {
        return userMapper.queryHead(userId);
    }
}
