package com.example.dataBaseUpdater.service;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import com.example.dataBaseUpdater.dao.DataDao;
import com.example.dataBaseUpdater.entity.Data;
import com.example.dataBaseUpdater.mapper.DataMapper;
import com.example.dataBaseUpdater.repository.DataRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DataGetter {
    private final DataRepository dataRepository;
    boolean checkIfExist(DataDao dataDao){
        boolean result =false;
        Data mapped = DataMapper.mapDataDaotoData(dataDao);
       List<Data>reserch = dataRepository.findAll(Example.of(mapped));
        if(reserch.size()>0)
            result=true;
        return result;
    }
}
