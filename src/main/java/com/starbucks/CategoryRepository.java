package com.starbucks;

import com.starbucks.domain.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Category category) {
        em.persist(category);
        return category.getId();
    }

    public Category find(Long id) {
        return em.find(Category.class, id);
    }



}
