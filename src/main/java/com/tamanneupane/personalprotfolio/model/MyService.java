package com.tamanneupane.personalprotfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "service")
@AllArgsConstructor
public class MyService {

    @Getter
    @Id
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "short_description")
    private String shortDescription;

    @Getter
    @Setter
    @Column(name = "icon")
    private String icon;

    public MyService() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyService service = (MyService) o;
        return Objects.equals(title, service.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "MyService{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
