package com.example.dataBaseUpdater.service;

import com.example.dataBaseUpdater.repository.DataRepository;

public class FacadeConfiguration {
    public static Facade createCodeSwiftCrudFacade(final DataRepository repository){
        return new Facade
        (new DataAdder(repository),new DataGetter(repository));
    }
}
