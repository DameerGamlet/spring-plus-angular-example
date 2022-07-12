package com.example.employeermanager.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public
class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(length = 500)
    private String description;

    public JobTitle(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
