package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
