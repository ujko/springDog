package com.sda.dog.dao;

import com.sda.dog.model.Dog;

import java.util.List;

public interface DogDAO {
    List<Dog> getAllDogs();
    Dog getById(int id);
    List<Dog> getByName(String name);
    List<Dog> getByBreed(String breed);
    List<Dog> getByNameAndBreed(String name, String breed);
    Dog addDog(Dog dog);
    Dog modifyDog(int id, Dog dog);
    Dog deleteDog(int id);
 }
