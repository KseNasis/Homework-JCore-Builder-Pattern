package com.company;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    protected boolean hasAge = false;
    protected boolean hasAddress = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasAge = true;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.hasAge = true;
        this.hasAddress = true;
    }

    public boolean hasAge() {
        return hasAge;
    }

    public boolean hasAddress() {
        return hasAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address == null ? "Адрес отсутствует!" : address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.hasAddress = true;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " лет " + "(Адрес: " + address + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }
}