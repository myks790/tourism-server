package com.myks790.tourismserver.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Integer period;

    @ManyToMany
    @JoinColumn(name = "plan_id")
    private List<Category> categories;

    private Boolean shared;

    private Integer numberOfShares;
    private Integer numberOfRecommendation;

    @OneToOne
    private User user;

//    @OneToOne
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    private Plan originalPlan;

    @OneToMany
    @JoinColumn(name = "plan_id")
    private List<Route> routes;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastUpdated;

    @Version
    private Integer version;
}
