package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.model.Plan;
import com.myks790.tourismserver.model.User;
import com.myks790.tourismserver.model.projection.PersonalPlan;
import com.myks790.tourismserver.repository.CategoryRepository;
import com.myks790.tourismserver.repository.PlanRepository;
import com.myks790.tourismserver.repository.UserRepository;
import com.myks790.tourismserver.util.ServiceUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/plan")
@AllArgsConstructor
public class PlanController {
    private UserRepository userRepository;
    private PlanRepository planRepository;
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public Page<Plan> list(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "25") Integer size, @RequestParam(required = false, defaultValue = "numberOfRecommendation,desc") String sort, @RequestParam(required = true, defaultValue = "popularity") String classification) {
        Pageable pageable = ServiceUtil.makePageRequest(page, size, sort);
        return planRepository.findAllBySharedIsTrue(pageable);
    }

    @GetMapping("/find")
    public Page<Plan> find(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "25") Integer size, @RequestParam(required = false, defaultValue = "id,desc") String sort, @RequestParam(defaultValue = "PLACE") String classification, @RequestParam(required = false, defaultValue = "1") String categories, @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = ServiceUtil.makePageRequest(page, size, sort);
        if (categories.isEmpty()) {
            if (classification.equals("PLACE"))
                return planRepository.findAllByTitleLike("%" + keyword + "%", pageable);
            else if(StringUtils.isNumeric(keyword))
                return planRepository.findAllByPeriod( Integer.parseInt(keyword), pageable);
        }else{
            List<Integer> categoryList = Arrays.stream(categories.split("-")).map(Integer::valueOf).collect(Collectors.toList());
            List<Category> selectedCategories = categoryRepository.findAllById(categoryList);

            if (classification.equals("PLACE"))
                return planRepository.findAllByCategoriesInAndTitleLike(selectedCategories,"%" + keyword + "%", pageable);
            else if(StringUtils.isNumeric(keyword))
                return planRepository.findAllByCategoriesInAndPeriod(selectedCategories, Integer.parseInt(keyword), pageable);
        }
        return null;
    }

    @GetMapping("recommend/{planId}")
    public Plan recommendPlan(@PathVariable Integer planId) {
        Plan plan = planRepository.findById(planId).get();
        plan.setNumberOfRecommendation(plan.getNumberOfRecommendation() + 1);
        return planRepository.save(plan);
    }

    @GetMapping("/{planId}")
    public Optional<Plan> get(@PathVariable Integer planId) {
        return planRepository.findById(planId);
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST})
    public Plan save(@RequestBody Plan plan) {
        List<Category> categories = plan.getCategories();
        categories = categoryRepository.findAllById(categories.stream().map(Category::getId).collect(Collectors.toList()));

        if (plan.getId() == null){
            return planRepository.save(plan);
        }else {
            Plan temp = planRepository.findById(plan.getId()).get();
            temp.setTitle(plan.getTitle());
            temp.setPeriod(plan.getPeriod());
            temp.setRoutes(plan.getRoutes());
            temp.setShared(plan.getShared());
            temp.setCategories(categories);
            return planRepository.save(temp);
        }
    }

    @DeleteMapping("/{planId}")
    public void delete(@PathVariable Integer planId) {
        Plan plan = planRepository.findById(planId).get();
        if(plan.getNumberOfRecommendation() > 10){
            plan.setUser(null);
            planRepository.save(plan);
        }else
            planRepository.deleteById(planId);
    }

    @GetMapping("/personalList/{userId}")
    public List<PersonalPlan> personalList(@PathVariable Integer userId){
        User user = userRepository.findById(userId).get();
        return planRepository.findAllByUser(user);
    }
}
