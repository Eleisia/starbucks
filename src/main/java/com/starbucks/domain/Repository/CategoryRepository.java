package com.starbucks.domain.Repository;

import com.starbucks.domain.Entity.Category;
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
