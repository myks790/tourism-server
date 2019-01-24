package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.DownloadedPlan;
import com.myks790.tourismserver.model.Plan;
import com.myks790.tourismserver.model.User;
import com.myks790.tourismserver.repository.DownloadedPlanRepository;
import com.myks790.tourismserver.repository.PlanRepository;
import com.myks790.tourismserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/downloadPlan")
@AllArgsConstructor
public class DownloadController {
    private UserRepository userRepository;
    private DownloadedPlanRepository downloadedPlanRepository;
    private PlanRepository planRepository;

    @GetMapping("/download")
    public DownloadedPlan download(@RequestParam Integer planId, @RequestParam Integer userId){
        User user = userRepository.findById(userId).get();
        Plan plan = planRepository.findById(planId).get();
        DownloadedPlan downloadedPlan = new DownloadedPlan();
        downloadedPlan.setPlan(plan);
        downloadedPlan.setUser(user);

        return downloadedPlanRepository.save(downloadedPlan);
    }

    @DeleteMapping("/{downloadPlanId}")
    public void delete(@PathVariable Integer downloadPlanId) {
        downloadedPlanRepository.deleteById(downloadPlanId);
    }
}
