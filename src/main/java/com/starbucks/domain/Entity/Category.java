package com.starbucks.domain.Entity;
//domain에 핵심 Entity 넣기
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;
    @NotNull
    private String categoryType;
    @NotNull
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryMenu> categoryMenus = new ArrayList<>();
}
