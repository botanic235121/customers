package com.sinitcyn.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Clients id_client;

    public Orders() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clients getId_client() {
        return id_client;
    }

    public void setId_client(Clients id_client) {
        this.id_client = id_client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(name, orders.name) &&
                Objects.equals(id_client, orders.id_client);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id_client);
    }
}
