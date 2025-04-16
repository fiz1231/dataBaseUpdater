package com.example.dataBaseUpdater.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

@NoArgsConstructor
public class DataDao {
    private Long id;
   
    private String adress;
   
    private String countryISO2;

    private Boolean isHeadquarter;
    
    private String swiftCode;

    private String countryName;

    public DataDao(Long id,String address,String countryISO2,Boolean isHeadquarter, String swiftCode,String countryName){
        this.id=id;
        this.adress=address.toUpperCase();
        this.countryISO2=countryISO2.toUpperCase();
        this.countryName = countryName.toUpperCase();
        this.isHeadquarter=isHeadquarter;
        this.swiftCode=swiftCode.toUpperCase();
    }
}

