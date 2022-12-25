package com.starbucks.service;

import com.starbucks.domain.Entity.Category;
import com.starbucks.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceTest {

    @Autowired CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void save() throws Exception {
        Category category = new Category();
        category.setCategoryName("이름1");
        category.setCategoryType("타입1");

        Long categoryId = categoryService.save(category);

        assertThat(categoryService.findOneCategory(categoryId)).isEqualTo(category);
    }

    @Test(expected = IllegalStateException.class)
    public void validate() throws Exception {
        Category category1 = new Category();
        Category category2 = new Category();

        category1.setCategoryName("이름1");
        category1.setCategoryType("타입2");
        category2.setCategoryName("이름1");
        category2.setCategoryType("타입1");

        categoryService.save(category1);
        categoryService.save(category2);

        fail("실패");
    }
}
