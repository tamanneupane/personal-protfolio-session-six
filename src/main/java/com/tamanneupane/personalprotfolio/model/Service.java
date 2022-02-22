package com.tamanneupane.personalprotfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public class Service {

    @Getter
    private String title;

    @Getter
    private String shortDescription;

    @Getter
    private String icon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(title, service.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
