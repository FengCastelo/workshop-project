package com.fengcastelo.project.Services;

import com.fengcastelo.project.Model.Entities.Order;
import com.fengcastelo.project.Repositories.OrderRepository;
import com.fengcastelo.project.Services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
         Optional<Order> obj = orderRepository.findById(id);
         return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
