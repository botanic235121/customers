package com.sinitcyn.demo.dataaccessobject;

import com.sinitcyn.demo.entity.Clients;

import java.util.List;

public interface ClientsDao {
    int createClient(Clients clients);

    /*int editClients(Clients clients);*/

    void deleteClients(int id);

    Clients getClientById(int id);

    List<Clients> getAllClients();
}
