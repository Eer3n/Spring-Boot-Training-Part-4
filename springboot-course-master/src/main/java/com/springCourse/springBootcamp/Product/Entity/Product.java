package com.springCourse.springBootcamp.Product.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Product.Entity.Base.BaseEntity;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
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
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    private String title;
    private String shortText;

    @Column(columnDefinition = "TEXT")
    private String longText;

    private Date insDate;
    private Date updDate;
    private double displayPrice;
    private double discountPrice;
    private Boolean isDeleted;

    @Override
    public Long getId() {
        return this.Id;
    }

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
