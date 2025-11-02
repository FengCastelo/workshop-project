package com.fengcastelo.project.Model.config;

import com.fengcastelo.project.Model.Entities.Category;
import com.fengcastelo.project.Model.Entities.Order;
import com.fengcastelo.project.Model.Entities.User;
import com.fengcastelo.project.Model.Entities.enums.OrderStatus;
import com.fengcastelo.project.Repositories.CategoryRepository;
import com.fengcastelo.project.Repositories.OrderRepository;
import com.fengcastelo.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User("maria@gmail.com", null,"Maria Brown",  "123456", "988888888");
        User u2 = new User("alex@gmail.com", null,"Alex Green",  "123456", "977777777");

        Order o1 = new Order( null, Instant.parse("2025-10-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order( null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2025-11-02T10:33:22Z"), OrderStatus.WAITING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}