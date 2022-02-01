package com.Cart.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "category_db")
@Data
public class Category {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column
    private String categoryName;

    @Column
    private String createdBy;

}
