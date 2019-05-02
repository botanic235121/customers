package com.sinitcyn.demo.dataaccessobject;

import com.sinitcyn.demo.entity.Client;

import java.util.List;

public interface ClientDao {

    Client getClientById(int id);

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(int id);

    List<Client> getAllClients();
}
