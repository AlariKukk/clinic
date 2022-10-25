package com.clinic.services;

import com.clinic.model.Owner;

import java.util.Set;

public interface OwnerService  extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
