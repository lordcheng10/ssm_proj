package com.jd.ssm.dao.order.impl;

import com.jd.ssm.dao.order.OrderDao;
import com.jd.ssm.model.Order;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cdchenlin6 on 2017/6/26.
 */
@Repository
public class OrderDaoImpl implements OrderDao{
    @Resource
    private SqlSessionTemplate ssmSqlSession;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(Order record) {
        return 0;
    }

    public int insertSelective(Order record) {
        ssmSqlSession.insert("OrderDao.insert",record);
        System.out.println("********************haha");
        return 0;
    }

    public Order selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Order record) {
        return 0;
    }

    public int updateByPrimaryKey(Order record) {
        return 0;
    }

    public List<Order> selectAllOrder() {
        return null;
    }
}
