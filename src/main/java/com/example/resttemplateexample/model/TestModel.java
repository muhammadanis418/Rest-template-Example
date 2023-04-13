package com.example.resttemplateexample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestModel {
    @Id
    private int id;
    private String name;
    private  Boolean isPresent;
    private int age;
    private  int rollNo;

}
