package com.example.demo.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name= "a")
public class Demo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="unique_id", nullable = false)
    private String uniqueId;

    @Column(name="is_deleted")
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    @PrePersist
    private void generateUniqueId() {
        this.uniqueId = UUID.randomUUID().toString();
    }

}