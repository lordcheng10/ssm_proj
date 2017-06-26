package com.jd.ssm.dao.order;

import com.jd.ssm.dao.order.impl.OrderDaoImpl;
import com.jd.ssm.model.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by cdchenlin6 on 2017/6/26.
 */
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;


    public void main(){
        Order oo = new Order();
        oo.setId(33);
       // oo.setCreatetime(new Date("2017-06-05 14:04:08"));
        oo.setNote("新增");
        oo.setUserId(1);
        oo.setNumber("1356832");

        orderDao.insert(oo);

    }
}
