package com.tamanneupane.personalprotfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {

    private String name;
    private String email;
    private String message;

}
