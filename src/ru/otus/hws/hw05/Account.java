package ru.otus.hws.hw05;

import ru.otus.hws.hw03.add.a.A;

import java.util.Objects;
import java.util.UUID;

class Account {
    //private UUID id = UUID.randomUUID();
    private long accountNumber = 1000000000000000l;
    private long accountVolume = 0l;

    Account(){
    }

    Account(long accountNumber){
        this.accountNumber = accountNumber;
    }

    Account(long accountNumber, long accountVolume){
        this.accountNumber = accountNumber;
        this.accountVolume = accountVolume;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAccountVolume() {
        return accountVolume;
    }

    public void setAccountVolume(long accountVolume) {
        this.accountVolume = accountVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountVolume);
    }
}
