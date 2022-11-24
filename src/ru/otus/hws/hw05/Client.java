package ru.otus.hws.hw05;

import java.util.Objects;
import java.util.UUID;

class Client {
    //private UUID id = UUID.randomUUID();
    private String name = "";
    private int age = 0;

    public Client() {};

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    };

//    public UUID getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null)  return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getAge() == client.getAge() && getName().equals(client.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
