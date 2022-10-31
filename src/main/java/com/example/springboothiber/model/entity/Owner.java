package com.example.springboothiber.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "owners", schema = "service")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    private int age;
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Car> cars;

    public Owner(String firstName, String lastName, int age) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Owner owner = (Owner) o;
        return id != null && Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
