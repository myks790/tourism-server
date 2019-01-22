package com.myks790.tourismserver.repository;

import com.myks790.tourismserver.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);
}
