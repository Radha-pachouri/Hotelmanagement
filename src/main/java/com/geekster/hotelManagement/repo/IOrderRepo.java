package com.geekster.hotelManagement.repo;

import com.geekster.hotelManagement.model.User;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderRepo extends JpaRepository<Order , Long> {
    List<Order> findByUser(User user);
}
