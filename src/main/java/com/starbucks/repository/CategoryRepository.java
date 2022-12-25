package com.starbucks.repository;

import com.starbucks.domain.Entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    public Long save(Category category) {
        em.persist(category);
        return category.getId();
    }

    public Category findOne(Long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    public List<Category> findByType(String type) {
        return em.createQuery("select c from Category c where c.categoryType = :type", Category.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<Category> findByName(String name) {
        return em.createQuery("select c from Category c where c.categoryName = :name", Category.class)
                .setParameter("name", name)
                .getResultList();
    }



}
