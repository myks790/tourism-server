package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.model.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    Page<Plan> findAllBySharedIsTrue(Pageable pageable);

    Page<Plan> findAllByTitleLike(String title, Pageable pageable);

    Page<Plan> findAllByPeriod(Integer period, Pageable pageable);

    Page<Plan> findAllByCategoriesInAndPeriod(List<Category> categories, Integer period, Pageable pageable);
    Page<Plan> findAllByCategoriesInAndTitleLike(List<Category> categories, String title, Pageable pageable);
}
