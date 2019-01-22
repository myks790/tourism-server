package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.DownloadedPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadedPlanRepository extends JpaRepository<DownloadedPlan, Integer> {
}
