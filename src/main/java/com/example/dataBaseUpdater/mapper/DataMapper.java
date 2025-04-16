package com.example.dataBaseUpdater.mapper;

import com.example.dataBaseUpdater.dao.DataDao;
import com.example.dataBaseUpdater.entity.Data;

public class DataMapper {
        static public DataDao mapDatatoDataDao(Data data){
        return new DataDao(data.getId(),data.getAdress(),data.getCountryISO2()
        ,data.getIsHeadquarter(),data.getSwiftCode(),data.getCountryName());
    }
    static public Data mapDataDaotoData (DataDao dataDao){
        return new Data(dataDao.getId(),dataDao.getAdress(),dataDao.getCountryISO2()
        ,dataDao.getIsHeadquarter(),dataDao.getSwiftCode(),dataDao.getCountryName());

    }
    
}

