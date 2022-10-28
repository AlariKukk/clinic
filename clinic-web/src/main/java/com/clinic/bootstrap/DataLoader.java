package com.clinic.bootstrap;

import com.clinic.model.Owner;
import com.clinic.model.Vet;
import com.clinic.services.OwnerService;
import com.clinic.services.VetService;
import com.clinic.services.map.OwnerServiceMap;
import com.clinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alari");
        owner1.setLastName("Kukk");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Pekka");
        owner2.setLastName("Haavisto");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Heidi");
        vet1.setLastName("Granholm");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mikael");
        vet2.setLastName("Granholm");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
