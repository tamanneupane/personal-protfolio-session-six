package com.tamanneupane.personalprotfolio.controller;

import com.tamanneupane.personalprotfolio.model.MyService;
import com.tamanneupane.personalprotfolio.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class APIController {

    @Autowired
    APIService apiService;

    @GetMapping(value = "/api/v1/services")
    public List<MyService> getAllServices(){
        return apiService.getAllService();
    }

    @PostMapping(value = "/api/v1/services")
    public String addService(@RequestBody MyService myService){
        System.out.println(myService);
        apiService.createService(myService);
        return "Post API Called";
    }

    @PutMapping(value = "/api/v1/services/{title}")
    public String updateService(@PathVariable String title, @RequestBody MyService myService){
        System.out.println(title);

        apiService.updateService(title, myService);

        return "Post API Called";
    }

    @DeleteMapping(value = "/api/v1/services/{title}")
    public String deleteService(@PathVariable String title){
        System.out.println(title);

        apiService.deleteService(title);

        return "Post API Called";
    }
}
