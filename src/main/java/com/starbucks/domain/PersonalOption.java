package com.starbucks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class PersonalOption {

    @Id @GeneratedValue
    @Column(name = "personal_option_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_size_id")
    private DrinkSize drinkSize;

    private String coffee;
    private String syrup;
    private String milkDrinkTemperature;
    private String cream;
    private String drizzle;
    private String topping;
    private String base;
    private String fruit_vegi;
    private String ice;
    private String cup_lid;
    private String etc;


}
