package com.tamanneupane.personalprotfolio.controller;

import com.tamanneupane.personalprotfolio.model.Contact;
import com.tamanneupane.personalprotfolio.model.PersonalInfo;
import com.tamanneupane.personalprotfolio.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.AuthenticationFailedException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping(value = "/")
    public String index(Model model){

        PersonalInfo personalInfo = new PersonalInfo();

        personalInfo.setFullName("Taman Neupane");
        personalInfo.setAddress("Bhaktapur, Nepal");
        personalInfo.setAge(28);
        personalInfo.setEmail("taman.neupane@gmail.com");
        personalInfo.setCvURL("https://www.google.com");
        personalInfo.setDescription("This is my test description");
        personalInfo.setYearsOfExperience(8);
        personalInfo.setHappyClient(50);
        personalInfo.setProjectDone(50);
        personalInfo.setNumberOfAwards(5);

        model.addAttribute("personalInfo", personalInfo);

        List<Service> services = new ArrayList<>();

        Service android = new Service("Android Application Development", "I can develop android application","fa-brands fa-android");
        Service ios = new Service("IOS Application Development", "I can develop IOS application","fa-brands fa-apple");
        Service react = new Service("React Application Development", "I can develop React application","fas fa-palette");

        services.add(android);
        services.add(ios);
        services.add(react);

        model.addAttribute("services", services);


        return "index";
    }

    @PostMapping(value = "/contact")
    public String sendEmail(@ModelAttribute Contact formData){
        // Email Pathaune code
        System.out.println(formData);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("taman.neupane@peacenepal.com");

        msg.setSubject("Mail from personal website");

        msg.setText("Name : " + formData.getName() + "\n" + "Email : " + formData.getEmail() + "\n" + "message : " + formData.getMessage());

        try{
            javaMailSender.send(msg);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "redirect:";
    }
}
