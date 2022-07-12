package com.example.employeermanager.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private String email;
    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "job_id", referencedColumnName = "id")
//    private JobTitle jobTitle;
    private String jobTitle;
    private String numberPhone;
    private String imageUrl;
    @Column(updatable = false, nullable = false)
    private String employeeCode;
    private LocalDateTime dateCreated;

    public Employee(String name, String email, String jobTitle, String numberPhone, String imageUrl) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.numberPhone = numberPhone;
        this.imageUrl = imageUrl;
    }

    public Employee(String name, String email, String numberPhone, String imageUrl) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
        this.imageUrl = imageUrl;
    }

    @PrePersist
    private void init() {
        dateCreated = LocalDateTime.now();
    }

}
