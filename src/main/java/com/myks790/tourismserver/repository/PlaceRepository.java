package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
