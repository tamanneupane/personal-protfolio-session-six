package com.tamanneupane.personalprotfolio.repository;

import com.tamanneupane.personalprotfolio.model.MyService;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<MyService,String> {
}
