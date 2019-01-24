package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);

    List<Category> findFirst7By();
}
