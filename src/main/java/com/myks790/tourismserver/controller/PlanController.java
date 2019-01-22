package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.Plan;
import com.myks790.tourismserver.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/plan")
@AllArgsConstructor
public class PlanController {
    private PlanRepository planRepository;

    @GetMapping("/list/{userID}")
    public List<Plan> list(@PathVariable Integer userID){
        return planRepository.findAll();

    }

}
