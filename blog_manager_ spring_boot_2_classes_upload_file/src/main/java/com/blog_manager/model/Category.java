package com.blog_manager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
//to use Lombok
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
}
