package com.geekster.hotelManagement.service;

import com.geekster.hotelManagement.model.AuthenticationToken;
import com.geekster.hotelManagement.model.OrderStatus;
import com.geekster.hotelManagement.repo.IOrderRepo;
import com.geekster.hotelManagement.repo.ITokenRepo;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepo orderRepo;

    @Autowired
    ITokenRepo tokenRepo;

    public List<Order> getOrders(String email, String token) {

        AuthenticationToken token1 = tokenRepo.findFirstByToken(token);
        if(token1.getUser().getRole().getRoleId()==1){
            return orderRepo.findAll();
        }else{
            List<Order> orderList = new ArrayList<>();
            orderList = orderRepo.findByUser(token1.getUser());
            return orderList;
        }
    }


    public void placeOrder(Order order, String token) {
    }

    public void updateOrder(String email, String token, Order order) {
    }
}
