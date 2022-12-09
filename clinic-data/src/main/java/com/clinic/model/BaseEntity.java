package com.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
//Base entity is a JPA concept where we can see we have JPA specific annotations on it
//Serialiseerimine(Serializable) on informaatikas objektide ja andmete teisendamine (konvertimine) selliseks, et need oleks esitatavad järjest.
//Serialiseerimise vastand on deserialiseerimine, mille käigus taastatakse objektide ja andmete serialiseerimiseelne seisund.