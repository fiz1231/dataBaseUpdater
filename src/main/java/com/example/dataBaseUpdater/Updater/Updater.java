package com.example.dataBaseUpdater.Updater;

import org.springframework.beans.factory.annotation.Configurable;

import com.example.dataBaseUpdater.dao.Country;
import com.example.dataBaseUpdater.dao.CountryAndBak;
import com.example.dataBaseUpdater.dao.CountryBankAndCity;
import com.example.dataBaseUpdater.dao.CountryBankCitySwift;
import com.example.dataBaseUpdater.dao.DataDao;
import com.example.dataBaseUpdater.service.Facade;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;



@AllArgsConstructor
public class Updater {
    private final Facade dataFacade;
    
    private static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    public void update(String[] args) throws Exception {
 
        
       
         
        
        List<Country> countries =getCountries();
        countries.forEach(x->System.out.println(x));
        Map<Country,
            Map<CountryAndBak,
                Map<CountryBankAndCity,
                    List<CountryBankCitySwift>>>>dataMap=new HashMap<>();
        
        
        try{
            //Problems with iteration suppose to pring all countries name but return only afganistan and null idk why
            for(Country x:countries){
              
                dataMap.put(x,null);
            }
            DataDao tmp = new DataDao();
            
            for(Country key:dataMap.keySet()){

                tmp.setCountryName(key.country());
                tmp.setCountryISO2(key.countryCode());

                dataMap.replace(key,getBanksFromCountry(key));
                Map<CountryAndBak,Map<CountryBankAndCity,List<CountryBankCitySwift>>> dataMapCountryAndBank =dataMap.get(key);
                    for(CountryAndBak countryKey :dataMapCountryAndBank.keySet()){

                        tmp.setAdress(countryKey.bank());

                        dataMapCountryAndBank.replace(countryKey,getCityFromBanks(key.countryCode(),countryKey.friendlyBank()));
                        Map<CountryBankAndCity,List<CountryBankCitySwift>> DataMapBankAndCity = dataMapCountryAndBank.get(countryKey);
                        for(CountryBankAndCity keyCountryBankAndCity:DataMapBankAndCity.keySet()){
                            List<CountryBankCitySwift> codes = getSwiftCodesFromBankAndCity(countryKey.friendlyBank(),keyCountryBankAndCity.friendlyCity());
                            DataMapBankAndCity.replace(keyCountryBankAndCity,codes);
                            
                            for(CountryBankCitySwift s: codes){
                                tmp.setSwiftCode(s.code());
                                if(s.code().endsWith("XXX"))
                                    {tmp.setIsHeadquarter(Boolean.TRUE);}
                                else{
                                    tmp.setIsHeadquarter(Boolean.FALSE);
                                }
                                dataFacade.addData(tmp);
                            }
                            
                        }
                    }
                
            }
            
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
 
    }
 
    // HTTP POST request
    private static List<Country> getCountries() throws Exception {
 
        String url = "https://swiftcodefinder.org/home/getcountry";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
        //add reuqest header
        con.setRequestMethod("GET");
        con.setRequestProperty("content-type", "application/json");
        con.setRequestProperty("Accept-Language", "pl,en;q=0.9,en-GB;q=0.8,en-US;q=0.7");
 
        
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        wr.flush();
        wr.close();
 
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        return objectMapper.readValue(response.toString(),new TypeReference<List<Country>>(){});
        
 
    }
    
    static private Map<CountryAndBak,Map<CountryBankAndCity,List<CountryBankCitySwift>>> getBanksFromCountry(Country country) throws Exception {
        String url = "https://swiftcodefinder.org/home/getbankbycountry/"+country.countryCode();
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
        //add reuqest header
        con.setRequestMethod("GET");
        con.setRequestProperty("content-type", "application/json");
        con.setRequestProperty("Accept-Language", "pl,en;q=0.9,en-GB;q=0.8,en-US;q=0.7");
 
        
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        wr.flush();
        wr.close();
 
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        //print result
        
        List<CountryAndBak> result = objectMapper.readValue(response.toString(),new TypeReference<List<CountryAndBak>>(){});
        Map<CountryAndBak,Map<CountryBankAndCity,List<CountryBankCitySwift>>> datamap = new HashMap<>();
        for(CountryAndBak x: result){
            datamap.put(x,null);
        }

        return datamap;
    }
    
    static private Map<CountryBankAndCity,List<CountryBankCitySwift>> getCityFromBanks(String  countryCode, String friendlyBank) throws Exception {
        String url = "https://swiftcodefinder.org/home/getcitybyankandcountry/"+countryCode+"/"+friendlyBank;
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
        //add reuqest header
        con.setRequestMethod("GET");
        con.setRequestProperty("content-type", "application/json");
        con.setRequestProperty("Accept-Language", "pl,en;q=0.9,en-GB;q=0.8,en-US;q=0.7");
 
        
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        wr.flush();
        wr.close();
 
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        //print result
        System.out.println("Countries: "+response.toString());

        List<CountryBankAndCity> result =objectMapper.readValue(response.toString(),new TypeReference<List<CountryBankAndCity>>(){});

        Map<CountryBankAndCity,List<CountryBankCitySwift>> datamap = new HashMap<>();
        for(CountryBankAndCity x: result){
            datamap.put(x,null);
        }
        
        return datamap;

        
    }
    
    static private List<CountryBankCitySwift> getSwiftCodesFromBankAndCity(String friendlybankName,String friendlycityName) throws Exception {
        String url = "https://swiftcodefinder.org/home/getswiftcodebybankandcity/"+friendlybankName+"/"+friendlycityName;
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
        //add reuqest header
        con.setRequestMethod("GET");
        con.setRequestProperty("content-type", "application/json");
        con.setRequestProperty("Accept-Language", "pl,en;q=0.9,en-GB;q=0.8,en-US;q=0.7");
 
        
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        wr.flush();
        wr.close();
 
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        //print result
        System.out.println(response.toString());

        List<CountryBankCitySwift> result =objectMapper.readValue(response.toString(),new TypeReference<List<CountryBankCitySwift>>(){});
        return result;
    }
}
