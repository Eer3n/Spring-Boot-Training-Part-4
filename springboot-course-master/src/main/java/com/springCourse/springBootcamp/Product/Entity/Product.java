package com.springCourse.springBootcamp.Product.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "SPRING_SELLER", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    //private Seller seller; ?
    private String title;
    private String  shortText;
    private String longText;
    private Date insDate;
    private Date updDate;
    private double displayPrice;
    private double discountPrice;
    private boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return Id != null && Objects.equals(Id, product.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
