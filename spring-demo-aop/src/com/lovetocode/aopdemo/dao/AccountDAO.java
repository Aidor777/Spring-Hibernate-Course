package com.lovetocode.aopdemo.dao;

import com.lovetocode.aopdemo.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    //    public void addAccount() {
//    public void addAccount(Account account) {
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + ": Doing DB work, adding an account");
    }

    public void doWork() {
        System.out.println(getClass() + ": Doing some work");
    }

    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        return List.of(
                new Account("John", "Silver"),
                new Account("Madhu", "Platinum"),
                new Account("Luca", "Gold"));
    }

}
