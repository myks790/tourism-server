package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
