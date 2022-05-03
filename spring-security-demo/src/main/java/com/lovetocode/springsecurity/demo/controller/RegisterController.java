package com.lovetocode.springsecurity.demo.controller;

import com.lovetocode.springsecurity.demo.model.CrmUser;
import com.lovetocode.springsecurity.demo.model.RoleEnum;
import com.lovetocode.springsecurity.demo.model.entity.User;
import com.lovetocode.springsecurity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    private final Map<String, String> roles = new LinkedHashMap<>();

    private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

    @PostConstruct
    private void loadRoles() {
        Arrays.stream(RoleEnum.values()).forEach(role -> roles.put(role.toSecurityRole(),
                StringUtils.capitalize(role.name().toLowerCase())));
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/registrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("crmUser", new CrmUser());
        model.addAttribute("roles", roles);
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser, BindingResult bindingResult, Model model) {
        String userName = crmUser.getUserName();
        LOGGER.info("Processing registration form for: " + userName);

        // form validation
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roles);
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name already exists.");
            model.addAttribute("roles", roles);

            LOGGER.warning("User name already exists.");
            return "registration - form";
        }

        // save user in the database
        userService.save(crmUser);

        LOGGER.info("Successfully created user: " + userName);
        return "registration-confirmation";
    }

}
