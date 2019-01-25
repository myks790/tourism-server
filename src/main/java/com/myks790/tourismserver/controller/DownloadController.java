package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.*;
import com.myks790.tourismserver.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/downloadPlan")
@AllArgsConstructor
public class DownloadController {
    private UserRepository userRepository;
    private DownloadedPlanRepository downloadedPlanRepository;
    private PlanRepository planRepository;
    private RouteRepository routeRepository;
    private CategoryRepository categoryRepository;

    @GetMapping("/download")
    public DownloadedPlan download(@RequestParam Integer planId, @RequestParam Integer userId){
        User user = userRepository.findById(userId).get();
        Plan plan = planRepository.findById(planId).get();
        Plan copy = new Plan();

        List<Category> categories = categoryRepository.findAllById(plan.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
        copy.setCategories(categories);
        copy.setUser(user);
        copy.setTitle(plan.getTitle());
        copy.setPeriod(plan.getPeriod());
        if(plan.getOriginalPlan() == null)
            copy.setOriginalPlan(plan);
        else
            copy.setOriginalPlan(plan.getOriginalPlan());
        copy = planRepository.save(copy);
        List<Route> routes = plan.getRoutes();
        List<Route> copiedRoutes = new ArrayList<>();
        for(Route r : routes){
            Route route = new Route();
            route.setDescription(r.getDescription());
            route.setRouteOrder(r.getRouteOrder());
            route.setDay(r.getDay());
            route.setPlace(r.getPlace());
            route.setPlan(copy);
            copiedRoutes.add(route);
        }
        copiedRoutes = routeRepository.saveAll(copiedRoutes);
        copy.setRoutes(copiedRoutes);

        DownloadedPlan downloadedPlan = new DownloadedPlan();
        downloadedPlan.setPlan(copy);
        downloadedPlan.setUser(user);

        return downloadedPlanRepository.save(downloadedPlan);
    }

    @DeleteMapping("/{downloadPlanId}")
    public void delete(@PathVariable Integer downloadPlanId) {
        DownloadedPlan downloadedPlan = downloadedPlanRepository.findById(downloadPlanId).get();
        Plan plan = downloadedPlan.getPlan();
        if(plan.getNumberOfRecommendation() > 10){
            plan.setUser(null);
            planRepository.save(plan);
        }
        downloadedPlanRepository.deleteById(downloadPlanId);
    }
}
