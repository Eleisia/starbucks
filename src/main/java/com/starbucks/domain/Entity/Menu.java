package com.starbucks.domain.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Menu {

    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    private String name;
    private String image;
    private String description;
    private String price;
    private String hot_ice;
    private String remarks;
    private String allergy;

    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<CategoryMenu> categoryMenus = new ArrayList<>();

    @OneToMany(mappedBy = "menu" ,cascade = CascadeType.ALL)
    private List<DrinkSize> drinkSizes  = new ArrayList<>();
}
