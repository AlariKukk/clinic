package com.clinic.services;


import com.clinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {

    Pet findById(Long id);

}
