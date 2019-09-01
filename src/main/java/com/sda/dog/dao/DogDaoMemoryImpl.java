package com.sda.dog.dao;

import com.sda.dog.model.Dog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DogDaoMemoryImpl implements DogDAO {
    private Map<Integer, Dog> dogMap;

    public DogDaoMemoryImpl() {
        dogMap = new HashMap<>();
        addDogs();
    }

    private void addDogs() {
        addDog(new Dog("Burek", "Jamnik", 3));
        addDog(new Dog("Fafik", "Rotweiler", 1));
        addDog(new Dog("Azor", "Wilczur", 5));
        addDog(new Dog("Dadi", "Jamnik", 2));
        addDog(new Dog("Rambo", "Jamnik", 8));
        addDog(new Dog("Rambo", "Pudel", 7));
    }

    private int generateId() {
        return dogMap
                .keySet()
                .stream()
                .mapToInt((x) -> x)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public List<Dog> getAllDogs() {
        return new ArrayList<>(dogMap.values());
    }

    @Override
    public Dog getById(int id) {
        return dogMap.get(id);
    }

    @Override
    public List<Dog> getByName(String name) {
        return getAllDogs()
                .stream()
                .filter((x)->x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dog> getByBreed(String breed) {
        return getAllDogs()
                .stream()
                .filter((x)->x.getBreed().toLowerCase().contains(breed.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dog> getByNameAndBreed(String name, String breed) {
        return getAllDogs()
                .stream()
                .filter((x)->x.getName().toLowerCase().contains(name.toLowerCase()))
                .filter((x)->x.getBreed().toLowerCase().contains(breed.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Dog addDog(Dog dog) {
        dog.setId(generateId());
        dogMap.put(dog.getId(), dog);
        return dog;
    }

    @Override
    public Dog modifyDog(int id, Dog dog) {
        dog.setId(id);
        dogMap.put(id, dog);
        return dog;
    }

    @Override
    public Dog deleteDog(int id) {
        return dogMap.remove(id);
    }
}
