package com.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass //the way we are setting up the mapping, we will never work with a Person POJO per se. We are going to be extending out from that.
public class Person extends BaseEntity {

    @Column(name = "first_name") //it's not actually needed to do that because hibernate would do that for us by default.
    private String firstName;
    @Column(name = "last_name") //it's not actually needed to do that because hibernate would do that for us by default.
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
