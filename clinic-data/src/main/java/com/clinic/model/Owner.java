package com.clinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    //for pets we have to set up a relationship mapping. @OneToMany so that we are going to have many pets here.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //cascade type means that if i delete an owner then that is going to cascade down, if i have pets and i delete the owner of the pet then the pets will also get deleted.
    private Set<Pet> pets = new HashSet<>();
}
