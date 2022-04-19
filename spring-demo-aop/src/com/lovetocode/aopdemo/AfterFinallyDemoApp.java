package com.lovetocode.aopdemo;

import com.lovetocode.aopdemo.config.DemoConfig;
import com.lovetocode.aopdemo.dao.AccountDAO;
import com.lovetocode.aopdemo.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            var accountDAO = context.getBean(AccountDAO.class);

            List<Account> accounts = List.of();
            try {
                accounts = accountDAO.findAccounts(false);
                accounts = accountDAO.findAccounts(true);
            } catch (Exception e) {
                System.out.println("\nMain program: caught exception " + e);
            }

            System.out.println("\nMain program: AfterFinallyDemoApp");
            System.out.println("-----");
            System.out.println(accounts);
            System.out.println();
        }
    }

}
