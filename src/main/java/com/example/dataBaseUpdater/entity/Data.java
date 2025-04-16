package com.example.dataBaseUpdater.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
@Table(name = "swift_data")
@Entity

public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="address")
    private String adress;
    @Column(name = "country_iso")
    private String countryISO2;
    @Column(name = "is_headquarter")
    private Boolean isHeadquarter;
    @Column(name="swift_code")
    private String swiftCode;
    @Column(name="country_name")
    private String countryName;
    
    public Data(Long id,String address,String countryISO2,Boolean isHeadquarter, String swiftCode,String countryName){
        this.id=id;
        this.adress=address.toUpperCase();
        this.countryISO2=countryISO2.toUpperCase();
        this.countryName = countryName.toUpperCase();
        this.isHeadquarter=isHeadquarter;
        this.swiftCode=swiftCode.toUpperCase();
    }
}

