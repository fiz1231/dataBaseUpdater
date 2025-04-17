package com.example.dataBaseUpdater.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataBaseUpdater.dao.DataDao;
import com.example.dataBaseUpdater.entity.Data;
import com.example.dataBaseUpdater.mapper.DataMapper;
import com.example.dataBaseUpdater.repository.DataRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Transactional
@Service
public class DataAdder {
    @Autowired
    private final DataRepository dataRepository;

    @Transactional
    Data addData(DataDao dataDao){
        
        Data mapped =DataMapper.mapDataDaotoData(dataDao);
        
        dataRepository.save(mapped);
       
        return mapped;
    }
}
