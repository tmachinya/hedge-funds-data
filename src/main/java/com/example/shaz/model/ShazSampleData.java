package com.example.shaz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sharon_sample_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShazSampleData {
    @Id
    private Integer id;
    private String activist;
    private String company;
    private String hfexec1;
    private String hfexec2;
    private String hfexec3;
    private String hfexec4;
    private String hfexec5;
    private String hfexec6;
    private String hfexec7;
    private String hfexec8;
    private String hfexec9;

    // Getters and Setters
}
