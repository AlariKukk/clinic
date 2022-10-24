package com.clinic.model;

import java.time.LocalDate;

public class Pet {

    private PetType petType;
    private Pet Pet;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Pet getPet() {
        return Pet;
    }

    public void setPet(Pet Pet) {
        this.Pet = Pet;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
