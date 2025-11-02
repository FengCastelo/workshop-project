package com.fengcastelo.project.Repositories;

import com.fengcastelo.project.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
