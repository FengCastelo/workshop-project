package com.fengcastelo.project.Repositories;

import com.fengcastelo.project.Model.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
