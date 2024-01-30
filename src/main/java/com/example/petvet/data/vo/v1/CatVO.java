package com.example.petvet.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@JsonPropertyOrder({"id","name"})
public class CatVO implements Serializable {

    private Long id;
    @JsonProperty("nome")
    private String name;


    @JsonIgnore
    private String genger;


    public CatVO(){}

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
