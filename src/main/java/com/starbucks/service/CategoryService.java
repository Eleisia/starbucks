package com.starbucks.service;

import com.starbucks.domain.Entity.Category;
import com.starbucks.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    //카테고리 삽입
    @Transactional
    public Long save(Category category) throws Exception {
        validateDuplicate(category);
        categoryRepository.save(category);
        return category.getId();
    }

    //중복검사
    public void validateDuplicate(Category category) throws Exception{
        List<Category> findCategories = categoryRepository.findByName(category.getCategoryName());
        if (findCategories.size() > 0) {
            throw new IllegalStateException("이미존재하는 카테고리이름입니다");
        }
    }

    //카테고리 전체 조회
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }
    public Category findOneCategory(Long id) {
        return categoryRepository.findOne(id);
    }
}
