package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.Category;
import com.myks790.tourismserver.model.Plan;
import com.myks790.tourismserver.repository.CategoryRepository;
import com.myks790.tourismserver.repository.PlanRepository;
import com.myks790.tourismserver.util.ServiceUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/plan")
@AllArgsConstructor
public class PlanController {
    private PlanRepository planRepository;
    private CategoryRepository categoryRepository;

    @GetMapping("/mainList")
    public List<Plan> mainList(@RequestParam(required = true, defaultValue = "popularity") String classification){
        if(classification.equals("popularity"))
            return planRepository.findTop12By();
        else if(classification.equals("new")){
            return planRepository.findTop12By();
        }
        return null;
    }

//    @GetMapping("/find")
//    public Page<Plan> find(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "50") Integer size, @RequestParam(required = false, defaultValue = "id,desc") String sort, @RequestParam(required = true, defaultValue = "PLACE") String classification, @RequestParam(required = false, defaultValue = "") String category, @RequestParam(required = true, defaultValue = "") String keyword){
//
//    }

    @GetMapping("/{userID}")
    public Optional<Plan> get(@PathVariable Integer userID){
        return planRepository.findById(userID);
    }

    @RequestMapping(value = "/{userId}", method = {RequestMethod.POST})
    public Plan save(@RequestBody Plan plan) {
        List<Category> categories = plan.getCategories();
        plan.setCategories(categoryRepository.findAllById(categories.stream().map(Category::getId).collect(Collectors.toList())));
        return planRepository.save(plan);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Integer userId) {
        planRepository.deleteById(userId);
    }
}
