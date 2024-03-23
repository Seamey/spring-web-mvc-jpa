package com.example.springwebmvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")  /// use to cusotmize table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // serial type (auto increment)
    private Integer id;
    @Column(unique = true,nullable = false,length = 40)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;


}
