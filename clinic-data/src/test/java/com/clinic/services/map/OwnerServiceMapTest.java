package com.clinic.services.map;

import com.clinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "Granholm";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        //we are mimicking here what Spring is going to do us in the Spring Context. Basically we are doing the dependency injection
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
        //this is going to save the owner. Basically this initializes OwnerServiceMap and puts one Owner object into it.
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    void findByLastName() {
        Owner granholm = ownerServiceMap.findByLastName(lastName);
        assertNotNull(granholm);
        assertEquals(ownerId, granholm.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner granholm = ownerServiceMap.findByLastName("foo");
        assertNull(granholm);
    }
}