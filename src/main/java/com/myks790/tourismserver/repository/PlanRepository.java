package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.model.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    List<Plan> findTop12By();

    Page<Plan> findAllByCategoriesContainsAndPeriod(List<Category> categories, Integer period, Pageable pageable);
}
