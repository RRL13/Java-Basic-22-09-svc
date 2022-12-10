package ru.otus.hws.hw05;

import java.util.*;

public class rrlBank {

    static HashMap<Client, ArrayList<Account>> storage = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        //Storage storage = new Storage();


        addClientsToStorage(storage, "Василий", 24);
        addClientsToStorage(storage, "Аггрипина", 37);
        addClientsToStorage(storage, "Михаил", 17);
        addClientsToStorage(storage, "Аггрипина", 38);

        Client requiredClient = new Client("Василий", 24);
        Account newAccount = new Account(4545567800000001l, 125);
        addAccountToClient(storage, findClientInStorage(storage, requiredClient), newAccount);
        newAccount = new Account(4545567800000002l, 500);
        addAccountToClient(storage, findClientInStorage(storage, requiredClient), newAccount);
        newAccount = new Account(4545567800000003l, 500);
        addAccountToClient(storage, findClientInStorage(storage, requiredClient), newAccount);

        addClientsToStorage(storage, new Client("Василий", 24));

        if (findClientInStorage(storage, requiredClient) != null) {

            for (Account i : getAccountsByClient(storage, findClientInStorage(storage, requiredClient))) {
                System.out.println(i.getAccountNumber());
            }
        }

        getAllClients(storage);


        if (findClientByAccount(storage, new Account( 4545567800000002l, 500)) != null) {
            System.out.println("Клиент: " + findClientByAccount(storage, new Account( 4545567800000002l, 500)).getName());
        }
    }


    public static void addNewClient(ArrayList<Client> clients, String clientName, int clientAge) {
        Client targetClient = new Client(clientName, clientAge);
        if (clients.equals(targetClient)) {
            System.out.println("Клиент с такими данными уже существует");
        } else {
            clients.add(targetClient);
        }
    }

    public static void addClientsToStorage(HashMap<Client, ArrayList<Account>> storage, Client newClient) {
        if (storage.containsKey(newClient)) {
            System.out.println("Такой клиент уже существует");
            return;
        }
        storage.put(newClient, null);
    }

    public static void addClientsToStorage(HashMap<Client, ArrayList<Account>> storage, String clientName, int clientAge) {
        Client newClient = new Client(clientName, clientAge);
        if (storage.containsKey(newClient)) {
            System.out.println("Клиент с таким именем уже существует");
            return;
        }
        storage.put(newClient, null);
    }

    public static void addAccountToClient(HashMap<Client, ArrayList<Account>> storage, Client client, Account newAccount) {
        ArrayList<Account> clientsAccounts = getAccountsByClient(storage, client);
        if (clientsAccounts == null) {
            clientsAccounts = new ArrayList<>();
        }
        clientsAccounts.add(newAccount);
        storage.put(client, clientsAccounts);
    }

    public static ArrayList<Account> getAccountsByClient(HashMap<Client, ArrayList<Account>> storage, Client client) {
        return storage.get(client);
    }

    public static Client findClientInStorage(ArrayList<Client> clientsList, Client requiredClient) {
        Iterator<Client> iterator = clientsList.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.equals(requiredClient)) {
                return client;

            }
        }
        System.out.println("Клиент с заданными параметрами не найден");
        return null;
    }

    public static Client findClientInStorage(HashMap<Client, ArrayList<Account>> storage, Client requiredClient) {
        Iterator<Client> iterator = storage.keySet().iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.equals(requiredClient)) {
                return client;

            }
        }
        System.out.println("Клиент с заданными параметрами не найден");
        return null;
    }

    public static Client findClientByAccount(HashMap<Client, ArrayList<Account>> storage, Account account) {
        if (storage != null) {
            Set<Map.Entry<Client, ArrayList<Account>>> storageAccounts = storage.entrySet();
            for (Map.Entry<Client, ArrayList<Account>> clientAccounts : storageAccounts) {
                if (clientAccounts.getValue() != null) {
                    for (Account currAccount : clientAccounts.getValue()) {
                        if (currAccount.equals(account)) {
                            return clientAccounts.getKey();
                        }
                    }
                }
            }
        }
        System.out.println("Счет с номером " + account.getAccountNumber() + " не найден.");
        return null;
    }

    public static void getAllClients(HashMap<Client, ArrayList<Account>> storage){
        int numClient = 1;
        for (Client c : storage.keySet()) {

            System.out.printf("Клиент №%d %s, возраст %d%n", numClient, c.getName(), c.getAge());
            numClient++;
        }
    }


}
