package com.lovetocode.aopdemo;

import com.lovetocode.aopdemo.config.DemoConfig;
import com.lovetocode.aopdemo.dao.AccountDAO;
import com.lovetocode.aopdemo.dao.MembershipDAO;
import com.lovetocode.aopdemo.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeDemoApp {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            var accountDAO = context.getBean(AccountDAO.class);
            var membershipDAO = context.getBean(MembershipDAO.class);

//            accountDAO.addAccount();
//            accountDAO.addAccount(new Account());
            accountDAO.addAccount(new Account("Madhu", "Platinum"), true);
            accountDAO.doWork();

            System.out.println();
            accountDAO.setName("foobar");
            accountDAO.setServiceCode("silver");
            accountDAO.getName();
            accountDAO.getServiceCode();

//            membershipDAO.addAccount();
            membershipDAO.addSillyMember();
            membershipDAO.goToSleep();

//            System.out.println("\nLet's do it again!\n");
//            accountDAO.addAccount();
        }
    }

}
