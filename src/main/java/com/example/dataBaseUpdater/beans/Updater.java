package com.example.dataBaseUpdater.beans;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import org.json.JSONArray;


@Configurable
public class Updater {
    
   
 
    public static void main(String[] args) throws Exception {
 
        Updater http = new Updater();
 
         
      
        http.getCountries();
 
    }
 
    // HTTP POST request
    private void getCountries() throws Exception {
 
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
 
        //print result
        System.out.println(response.toString());
 
    }
    private void getBanksFromCountry(String countryCodeI02) throws Exception {
        String url = "https://swiftcodefinder.org/home/getbankbycountry/"+countryCodeI02;
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
    }
    private void getCityFromBanks(String countryCodeI02,String cityName) throws Exception {
        String url = "https://swiftcodefinder.org/home/getcitybyankandcountry/"+countryCodeI02+"/"+cityName;
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
    }
    private void getSwiftCodesFromBankAndCity(String bankName,String cityName) throws Exception {
        String url = "https://swiftcodefinder.org/home/getswiftcodebybankandcity/"+bankName+"/"+cityName;
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
    }
}
