package com.clinic.bootstrap;

import com.clinic.model.Owner;
import com.clinic.model.PetType;
import com.clinic.model.Vet;
import com.clinic.services.OwnerService;
import com.clinic.services.PetTypeService;
import com.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alari");
        owner1.setLastName("Kukk");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Pekka");
        owner2.setLastName("Haavisto");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Heidi");
        vet1.setLastName("Granholm");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mikael");
        vet2.setLastName("Granholm");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
