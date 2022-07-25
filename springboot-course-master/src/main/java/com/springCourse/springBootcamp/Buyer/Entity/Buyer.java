package com.springCourse.springBootcamp.Buyer.Entity;

import com.springCourse.springBootcamp.User.Entity.User;
import com.springCourse.springBootcamp.User.Enum.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SPRING_BUYER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Buyer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String surname;
    private String username;
    private String mailAddress;
    private String password;
    private Integer age;
    private String imageUrl;
    private Boolean isBanned;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    private String backupMailAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Buyer buyer = (Buyer) o;
        return Id != null && Objects.equals(Id, buyer.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
