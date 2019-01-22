package com.myks790.tourismserver.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


public enum  PlaceCategory {
    AREA("지역"),
    RESTAURANT("음식점"),
    TOURIST_SPOTS("관광지"),
    LODGING("숙소");

    private final String name;

    PlaceCategory(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
