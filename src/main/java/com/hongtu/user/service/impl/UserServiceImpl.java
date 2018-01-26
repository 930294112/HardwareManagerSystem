package com.hongtu.user.service.impl;
import com.hongtu.user.bean.User;
import com.hongtu.user.bean.ext.ExtUser;
import com.hongtu.user.mapper.AdressMapper;
import com.hongtu.user.mapper.UserMapper;
import com.hongtu.user.service.UserService;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private AdressMapper adressMapper;

    /**
     * 查询所有的用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageBean<User> findAllUser(Integer pageNum, int pageSize) {
        int totalCount= userMapper.findCount();
        PageBean<User> pageBean = new PageBean<User>(pageNum,pageSize,totalCount);
        List<User> users = userMapper.findAll(pageBean);
        pageBean.setData(users);
        return pageBean;
    }

    public List<Integer> deleteByIds(String[] deleteIds) {
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (String deleteId : deleteIds) {
            int c = adressMapper.deleteById(deleteId);
            if (c>0){
                count = userMapper.deleteById(deleteId);
            }

            if (count > 0){
                 list.add(count);
             }
        }
        return list;
    }

    public PageBean<User> query(ExtUser extUser, Integer pageNum, int pageSize) {
        int totalCount = userMapper.findCountQueyr(extUser);
        PageBean<User> pageBean = new PageBean<User>(pageNum,pageSize,totalCount);
        pageBean.setT(extUser);
        List<User> users = userMapper.query(pageBean);
        pageBean.setData(users);
        return pageBean;
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
