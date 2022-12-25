package com.starbucks.repository;

import com.starbucks.domain.Entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;
    Category category4;

    Long savedId;
    Long savedId2;
    Long savedId3;



//    @Test(expected = ConstraintViolationException.class)
//    @Transactional
//    @Rollback(value = false)
//    public void testNull(){
//        category4 = new Category();
//        category4.setCategoryType("FOOD2");
//        log.info("CHK NAME {}",category4.getCategoryName());
//        log.info("CHK TYPE {}",category4.getCategoryType());
//        assertThat(category4.getCategoryName()).isNull();
//        assertThat(categoryRepository.save(category4)).isEqualTo(4L);
//
//        log.info("CHK SAVEDID {}",categoryRepository.save(category4));
//    }

    @Test
    @Transactional
    @Rollback(false)
    public void testFind()  {

        Category category = new Category();
        category.setCategoryType("FOOD");
        category.setCategoryName("추천");

        Category category2 = new Category();
        category2.setCategoryType("FOOD2");
        category2.setCategoryName("추천2");

        Category category3 = new Category();
        category3.setCategoryType("FOOD2");
        category3.setCategoryName("추천2");

        savedId = categoryRepository.save(category);
        savedId2 = categoryRepository.save(category2);
        savedId3 = categoryRepository.save(category3);

        Category findCategory = categoryRepository.findOne(savedId);
        Category findCategory2 = categoryRepository.findOne(savedId2);
        assertThat(findCategory.getId()).isEqualTo(category.getId());
        assertThat(findCategory.getCategoryName()).isEqualTo(category.getCategoryName());
        assertThat(findCategory.getCategoryType()).isEqualTo(category.getCategoryType());

        assertThat(findCategory2.getId()).isEqualTo(category2.getId());
        assertThat(findCategory2.getCategoryName()).isEqualTo(category2.getCategoryName());
        assertThat(findCategory2.getCategoryType()).isEqualTo(category2.getCategoryType());

        assertThat(categoryRepository.findAll().size()).isEqualTo(3);

        assertThat(categoryRepository.findByName("추천").size()).isEqualTo(1);
        assertThat(categoryRepository.findByName("임시").size()).isEqualTo(0);

        assertThat(categoryRepository.findByType("FOOD2").size()).isEqualTo(2);
        assertThat(categoryRepository.findByType("없음").size()).isEqualTo(0);

    }

}