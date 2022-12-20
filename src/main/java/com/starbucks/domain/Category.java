package com.starbucks.domain;
//domain에 핵심 Entity 넣기
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;
    private String categoryType;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<CategoryMenu> categoryMenus = new ArrayList<>();
}
