package com.lovetocode.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovetocode.jackson.demo.model.Student;

import java.io.File;

public class Driver {

    public static void main(String[] args) throws Exception {
        var mapper = new ObjectMapper();
        var student = mapper.readValue(new File("data/sample-full.json"), Student.class);

        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());

        var address = student.getAddress();
        if (address != null) {
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
        }

        System.out.println(student.getLanguages());
    }
}
