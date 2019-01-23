package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.Plan;
import com.myks790.tourismserver.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/plan")
@AllArgsConstructor
public class PlanController {
    private PlanRepository planRepository;

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
//    public Page<Plan> list(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "50") Integer size, @RequestParam(required = false, defaultValue = "id,desc") String sort ){
//        return planRepository.findTop12By(ServiceUtil.makePageRequest(page, size, sort));
//    }

    @GetMapping("/{userID}")
    public Optional<Plan> get(@PathVariable Integer userID){
        return planRepository.findById(userID);
    }

    @RequestMapping(value = "/{userId}", method = {RequestMethod.POST})
    public Plan save(@RequestBody Plan plan) {
        return planRepository.save(plan);
    }


}
