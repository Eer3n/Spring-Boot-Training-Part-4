package com.springCourse.springBootcamp.Seller.Entity;

import com.springCourse.springBootcamp.User.Entity.User;
import com.springCourse.springBootcamp.User.Enum.Countries;
import com.springCourse.springBootcamp.User.Enum.UserStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SPRING_SELLER", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Seller extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String username;
    private String mailAddress;
    private String password;
    private String storeName;
    private int totalProducts;
    private int totalScore;
    private Countries countriesThatSells;
    private UserStatus userStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Seller seller = (Seller) o;
        return Id != null && Objects.equals(Id, seller.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
