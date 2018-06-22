package com.sinitcyn.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;

    public Clients() {
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
        Clients clients = (Clients) o;
        return Objects.equals(firstName, clients.firstName) &&
                Objects.equals(lastName, clients.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}
