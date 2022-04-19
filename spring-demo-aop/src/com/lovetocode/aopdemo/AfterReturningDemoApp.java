package com.lovetocode.aopdemo;

import com.lovetocode.aopdemo.config.DemoConfig;
import com.lovetocode.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            var accountDAO = context.getBean(AccountDAO.class);

            var accounts = accountDAO.findAccounts(false);

            System.out.println("\nMain program: AfterReturningDemoApp");
            System.out.println("-----");
            System.out.println(accounts);
            System.out.println();
        }
    }

}
