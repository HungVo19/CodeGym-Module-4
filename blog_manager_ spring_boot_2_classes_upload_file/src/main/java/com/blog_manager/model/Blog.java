package com.blog_manager.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String description;
    private String content;
    private LocalDate postedDate;
    @ManyToOne(targetEntity = Category.class)
    private Category category;
}
