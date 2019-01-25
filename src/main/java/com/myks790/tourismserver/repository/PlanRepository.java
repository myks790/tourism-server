package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.model.Plan;
import com.myks790.tourismserver.model.User;
import com.myks790.tourismserver.model.projection.PersonalPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    Page<Plan> findAllBySharedIsTrue(Pageable pageable);

    Page<Plan> findAllByTitleLike(String title, Pageable pageable);

    Page<Plan> findAllByPeriod(Integer period, Pageable pageable);

    Page<Plan> findAllByCategoriesInAndPeriod(List<Category> categories, Integer period, Pageable pageable);

    Page<Plan> findAllByCategoriesInAndTitleLike(List<Category> categories, String title, Pageable pageable);

    @Query(value = "SELECT new com.myks790.tourismserver.model.projection.PersonalPlan(p, d) FROM Plan as p LEFT JOIN DownloadedPlan as d ON p.id = d.plan WHERE p.user = :user OR d.user = :user")
    List<PersonalPlan> findAllByUser(@Param(value = "user") User user);
}
