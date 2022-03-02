package com.tamanneupane.personalprotfolio.controller;

import com.tamanneupane.personalprotfolio.annotation.ModifyResponse;
import com.tamanneupane.personalprotfolio.model.MyService;
import com.tamanneupane.personalprotfolio.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class APIController {

    @Autowired
    APIService apiService;

    @ModifyResponse
    @GetMapping(value = "/api/v1/services")
    public List<MyService> getAllServices(){
        return apiService.getAllService();
    }

    @ModifyResponse
    @PostMapping(value = "/api/v1/services")
    public ResponseEntity<MyService> addService(@Valid @RequestBody MyService myService){
        System.out.println(myService);
        var savedService = apiService.createService(myService);
        return ResponseEntity.ok(savedService);
    }

    @ModifyResponse
    @PutMapping(value = "/api/v1/services/{title}")
    public ResponseEntity<MyService> updateService(@PathVariable String title, @RequestBody MyService myService){
        System.out.println(title);

        var updatedService = apiService.updateService(title, myService);

        return ResponseEntity.ok(updatedService);
    }

    @ModifyResponse
    @DeleteMapping(value = "/api/v1/services/{title}")
    public ResponseEntity<String> deleteService(@PathVariable String title){
        System.out.println(title);

        apiService.deleteService(title);

        return ResponseEntity.ok("Service deleted successfully");
    }
}
