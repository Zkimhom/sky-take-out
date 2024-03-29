package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface OrderMapper {
     /**
      * 插入订单数据
      * @param orders
      */
     void insert(Orders orders);

     /**
      * 根据订单号查询订单
      * @param orderNumber
      */
     @Select("select * from orders where number = #{orderNumber}")
     Orders getByNumber(String orderNumber);

     /**
      * 修改订单信息
      * @param orders
      */
     void update(Orders orders);

     /**

      * 用于替换微信支付更新数据库状态的问题

      * @param orderStatus

      * @param orderPaidStatus

      */

     @Update("update orders set status = #{orderStatus},pay_status = #{orderPaidStatus} ,checkout_time = #{check_out_time} where number = #{id}")
     void updateStatus(Integer orderStatus, Integer orderPaidStatus, LocalDateTime check_out_time, Long id);

     /**
      * 根据id查询订单表详细信息
      * @param id
      * @return
      */
     @Select("select * from orders where id = #{id}")
     Orders getById(Long id);

     /**
      * 用户端分页查询
      * @param ordersPageQueryDTO
      * @return
      */
     Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

     /**
      * 各个状态的订单数量统计
      * @param status
      * @return
      */
     @Select("select count(id) from orders where status = #{status}")
     Integer countStatus(Integer status);
}
