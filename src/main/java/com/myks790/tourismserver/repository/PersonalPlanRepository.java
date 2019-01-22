package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.PersonalPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalPlanRepository extends JpaRepository<PersonalPlan, Integer> {
}
