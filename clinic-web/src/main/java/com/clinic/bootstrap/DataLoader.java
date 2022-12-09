package com.clinic.bootstrap;

import com.clinic.model.*;
import com.clinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alari");
        owner1.setLastName("Kukk");
        owner1.setAddress("Talonmäenkatu 9");
        owner1.setCity("Turku");
        owner1.setTelephone("123456789");

        Pet alarisPet = new Pet();
        alarisPet.setPetType(savedDogPetType);
        alarisPet.setOwner(owner1);
        alarisPet.setBirthDate(LocalDate.now());
        alarisPet.setName("Neppi");
        owner1.getPets().add(alarisPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Pekka");
        owner2.setLastName("Haavisto");
        owner2.setAddress("Pekkakatu 6");
        owner2.setCity("Helsinki");
        owner2.setTelephone("123456789");

        Pet pekkasPet = new Pet();
        pekkasPet.setPetType(savedCatPetType);
        pekkasPet.setOwner(owner2);
        pekkasPet.setBirthDate(LocalDate.now());
        pekkasPet.setName("Haav");
        owner2.getPets().add(pekkasPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(pekkasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kissa");

        visitService.save(catVisit);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Heidi");
        vet1.setLastName("Granholm");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mikael");
        vet2.setLastName("Granholm");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
