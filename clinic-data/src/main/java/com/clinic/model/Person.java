package com.clinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //the way we are setting up the mapping, we will never work with a Person POJO per se. We are going to be extending out from that.
public class Person extends BaseEntity {

    @Column(name = "first_name") //it's not actually needed to do that because hibernate would do that for us by default.
    private String firstName;
    @Column(name = "last_name") //it's not actually needed to do that because hibernate would do that for us by default.
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
