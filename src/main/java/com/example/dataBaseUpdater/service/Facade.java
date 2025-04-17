package com.example.dataBaseUpdater.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataBaseUpdater.dao.DataDao;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class Facade {
    
    private final DataAdder dataAdder;
    private final DataGetter dataGetter;
    public void addData(DataDao datainput){
        if(!dataGetter.checkIfExist(datainput))
        {
            dataAdder.addData(datainput);
        }
        
    }
}
