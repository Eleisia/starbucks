package com.starbucks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DrinkSize {

    @Id
    @GeneratedValue
    @Column(name = "drink_size_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToOne(mappedBy = "drinkSize", fetch = FetchType.LAZY)
    private PersonalOption personalOption;

    @Enumerated(EnumType.STRING)
    private Size size; //사이즈 [SHORT, TALL, GRANDE, VENTI]

}
