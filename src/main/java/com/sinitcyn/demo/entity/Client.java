package com.sinitcyn.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String firstName;

    private String lastName;

    public Client() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client clients = (Client) o;
        return id == clients.id &&
                Objects.equals(firstName, clients.firstName) &&
                Objects.equals(lastName, clients.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
