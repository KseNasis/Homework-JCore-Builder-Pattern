package com.company;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if ((age < 0) || (age > 150)) {
            throw new IllegalArgumentException("Не корректно указан возраст. Возраст должен быть от 0 до 150 лет");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException,IllegalArgumentException {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не указанны имя и/или фамилия");
        }
        Person person = new Person(name, surname, age);
        person.setAddress(address);

        return person;
    }
}