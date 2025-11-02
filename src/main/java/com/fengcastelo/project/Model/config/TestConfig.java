package com.fengcastelo.project.Model.config;

import com.fengcastelo.project.Model.Entities.Order;
import com.fengcastelo.project.Model.Entities.User;
import com.fengcastelo.project.Repositories.OrderRepository;
import com.fengcastelo.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("maria@gmail.com", null,"Maria Brown",  "123456", "988888888");
        User u2 = new User("alex@gmail.com", null,"Alex Green",  "123456", "977777777");

        Order o1 = new Order(u1, null, Instant.parse("2025-10-20T19:53:07Z"));
        Order o2 = new Order(u2, null, Instant.parse("2025-07-21T03:42:10Z"));
        Order o3 = new Order(u1,null, Instant.parse("2025-11-02T10:33:22Z"));

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}