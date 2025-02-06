package com.sabbir.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "shop_table")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Integer id;
    @Column(name = "shop_name")
    private String name;
    @Column(name = "shop_category")
    private String category;
}
