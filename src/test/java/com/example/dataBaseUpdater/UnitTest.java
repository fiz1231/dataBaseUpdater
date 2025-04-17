package com.example.dataBaseUpdater;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;


import com.example.dataBaseUpdater.dao.DataDao;
import com.example.dataBaseUpdater.service.Facade;
import com.example.dataBaseUpdater.service.FacadeConfiguration;
import org.assertj.core.api.Assertions;
@SpringBootTest
public class UnitTest {
    @Autowired
    private final Facade testFacade = FacadeConfiguration.createCodeSwiftCrudFacade(new InmemoryReposytory());
    @Test
    @Description("check Adding new Data object")
    public void testaddingData(){
        //given
        DataDao testingData = new DataDao(null,"TESTADDRESS","TESTCOUNTRYISO2"
        ,true,"TESTSWIFTCODE","TESTCOUNTRYNAME");
        // when should not return error 
        testFacade.addData(testingData);
        //then
        
        Assertions.assertThat(true);
    }
}
