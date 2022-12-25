package com.starbucks.service;

import com.starbucks.domain.Entity.Menu;
import com.starbucks.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public List<Menu> findMenus() {
        return menuRepository.findAll();
    }

    public Menu findOne(Long id) {
        return menuRepository.findOne(id);
    }
}
