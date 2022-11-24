package ru.otus.hws.hw05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Storage {
    Map<Client, ArrayList<Account>> storage = new HashMap<>();
    ArrayList<Client> clients = new ArrayList<>();

    public void addNewClient(ArrayList<Client> clients, String clientName, int clientAge){
        Client targetClient = new Client(clientName, clientAge);
        if (clients.equals(targetClient)) {
            System.out.println("Клиент с такими данными уже существует");
        } else {
            clients.add(targetClient);
        }
    }
}
