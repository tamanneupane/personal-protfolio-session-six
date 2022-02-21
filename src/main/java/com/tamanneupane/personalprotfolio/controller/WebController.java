package com.tamanneupane.personalprotfolio.controller;

import com.tamanneupane.personalprotfolio.model.PersonalInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/")
    public String index(Model model){

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFullName("Taman Neupane");
        personalInfo.setAddress("Bhaktapur, Nepal");
        personalInfo.setAge(28);
        personalInfo.setEmail("taman.neupane@gmail.com");
        personalInfo.setCvURL("https://www.google.com");
        personalInfo.setDescription("This is my test description");

        model.addAttribute("personalInfo", personalInfo);

        return "index";
    }
}
