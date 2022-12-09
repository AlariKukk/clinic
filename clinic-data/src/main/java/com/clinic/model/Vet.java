package com.clinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER) //anything that is a many relationship is going to be lazily initialized. when we set it to eager, that means that JPA is going to load everything all at once. By lazy initialization, which is the default, it doesn't load until it it's asked for.
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))//Join table is a special table that's going to sit between so the entities are going to have their own relationship but the underlying database is going to have a table that's going to define IDs from both sides of their relationships.
    private Set<Speciality> specialities = new HashSet<>();
}
