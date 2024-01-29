package com.example.petvet.entities;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name="cats")
@Getter
@Setter
public class Cat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false)
    private String name;


    public Cat(){}
    public Cat(long id, String name){
        this.name = name;
        this.id = id;
    };


    public Cat( String name){
        this.name = name;

    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
