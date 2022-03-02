package com.tamanneupane.personalprotfolio.service;

import com.tamanneupane.personalprotfolio.exceptions.ServiceNotFoundException;
import com.tamanneupane.personalprotfolio.model.MyService;
import com.tamanneupane.personalprotfolio.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class APIService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<MyService> getAllService(){
        List<MyService> myServices = new ArrayList<>();
        serviceRepository.findAll().forEach(myServices::add);
        return  myServices;
    }


    public MyService createService(MyService myService) {
        return serviceRepository.save(myService);
    }

    public MyService updateService(String title, MyService myService) {
        Optional<MyService> optionalService = serviceRepository.findById(title);

        if(optionalService.isPresent()){
            MyService service = optionalService.get();

            if(myService.getShortDescription() != null)
                service.setShortDescription(myService.getShortDescription());

            if(myService.getIcon() != null)
                service.setIcon(myService.getIcon());

            return serviceRepository.save(service);

        }else{
            throw new ServiceNotFoundException(404,"Service not found");
        }
    }

    public void deleteService(String title) {
        serviceRepository.deleteById(title);
    }
}
