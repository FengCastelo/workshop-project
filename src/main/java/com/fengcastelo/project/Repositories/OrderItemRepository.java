package com.fengcastelo.project.Repositories;

import com.fengcastelo.project.Model.Entities.OrderItem;
import com.fengcastelo.project.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
