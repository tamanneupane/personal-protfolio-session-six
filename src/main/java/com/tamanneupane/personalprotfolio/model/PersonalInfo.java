package com.tamanneupane.personalprotfolio.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonalInfo {
    private String fullName;
    private String address;
    private String email;
    private int age;
    private String description;
    private String cvURL;

    private int yearsOfExperience;
    private int happyClient;
    private int projectDone;
    private int numberOfAwards;

    private List<String> names = new ArrayList<>();
}
