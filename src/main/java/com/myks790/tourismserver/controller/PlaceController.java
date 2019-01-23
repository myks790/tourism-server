package com.myks790.tourismserver.controller;

import com.myks790.tourismserver.model.Place;
import com.myks790.tourismserver.model.PlaceCategory;
import com.myks790.tourismserver.repository.PlaceRepository;
import com.myks790.tourismserver.util.ServiceUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/place")
@AllArgsConstructor
public class PlaceController {
    private PlaceRepository placeRepository;


    @GetMapping("/find")
    public Page<Place> find(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "50") Integer size, @RequestParam(required = false, defaultValue = "id,desc") String sort , @RequestParam(required = true, defaultValue = "TOURIST_SPOTS") String category, @RequestParam(required = true, defaultValue = "") String name){
        Pageable pageable = ServiceUtil.makePageRequest(page, size, sort);
        if(PlaceCategory.AREA != PlaceCategory.valueOf(category)){
            return placeRepository.findALlByPlaceCategoryAndNameLike(PlaceCategory.valueOf(category), "%"+name+"%", pageable);
        }
        else
            return placeRepository.findALlByLocationLike("%"+name+"%", pageable);
    }
}
