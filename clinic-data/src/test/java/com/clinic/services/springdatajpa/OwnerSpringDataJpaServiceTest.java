package com.clinic.services.springdatajpa;

import com.clinic.model.Owner;
import com.clinic.repositories.OwnerRepository;
import com.clinic.repositories.PetRepository;
import com.clinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    public static final String LAST_NAME = "Granholm";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSpringDataJpaService ownerSpringDataJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSpringDataJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSpringDataJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSpringDataJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownetToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSpringDataJpaService.save(ownetToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void deleteById() {
        ownerSpringDataJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void delete() {
        ownerSpringDataJpaService.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        //when and any are methods of mockito. we just told the mockito that when ownerSpringDataJpaService.findByLastName()

        Owner granholm = ownerSpringDataJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, granholm.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}