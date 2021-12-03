package com.lovetocode.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String letsShoutDude(/*HttpServletRequest request*/ @RequestParam("studentName") String name, Model model) {
        /*// Read request parameter from HTML form
        String name = request.getParameter("studentName");*/

        // Convert to upper case (shout)
        name = name.toUpperCase(Locale.ROOT);

        String message = "Yo " + name + "!";

        // Add the message to the model
        model.addAttribute("message", message);

        return "helloworld";
    }
}
