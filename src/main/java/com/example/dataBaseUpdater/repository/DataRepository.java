package com.example.dataBaseUpdater.repository;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.Repository;

import com.example.dataBaseUpdater.entity.Data;

@org.springframework.stereotype.Repository
public interface DataRepository extends Repository<Data,Long> {
    
    Data save (Data inputRow);
    
    List<Data> findAll(Example<Data> example);
   
}
