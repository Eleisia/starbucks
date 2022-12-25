package com.starbucks;

import com.starbucks.domain.Entity.Category;
import com.starbucks.domain.Repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testCategory() throws Exception {
        Category category = new Category();
        category.setCategoryType("FOOD");
        category.setCategoryName("추천");

        Category category2 = new Category();
        category2.setCategoryType("FOOD2");
        category2.setCategoryName("추천2");

        Long savedId = categoryRepository.save(category);
        Long savedId2 = categoryRepository.save(category2);

        Category findCategory = categoryRepository.find(savedId);
        Category findCategory2 = categoryRepository.find(savedId2);
        Assertions.assertThat(findCategory.getId()).isEqualTo(category.getId());
        Assertions.assertThat(findCategory.getCategoryName()).isEqualTo(category.getCategoryName());
        Assertions.assertThat(findCategory.getCategoryType()).isEqualTo(category.getCategoryType());

        Assertions.assertThat(findCategory2.getId()).isEqualTo(category2.getId());
        Assertions.assertThat(findCategory2.getCategoryName()).isEqualTo(category2.getCategoryName());
        Assertions.assertThat(findCategory2.getCategoryType()).isEqualTo(category2.getCategoryType());

    }

}