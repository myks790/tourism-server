package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.DownloadedPlan;
import com.myks790.tourismserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DownloadedPlanRepository extends JpaRepository<DownloadedPlan, Integer> {

    List<DownloadedPlan> findAllByUser(User user);
}
