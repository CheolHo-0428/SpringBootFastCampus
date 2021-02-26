package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        //어떤 사람?
        //orderDetail.setItemId(1L);

        //어떤 물건?
        //orderDetail.setUser(5L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assertions.assertNotNull(newOrderDetail);

    }

}
