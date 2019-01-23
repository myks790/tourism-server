package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Place;
import com.myks790.tourismserver.model.PlaceCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Place findByName(String name);

    Page<Place> findALlByPlaceCategoryAndNameLike(PlaceCategory placeCategory, String name, Pageable pageable);
    Page<Place> findALlByLocationLike(String name, Pageable pageable);
}
